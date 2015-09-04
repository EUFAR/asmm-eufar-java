package com.eufar.asmm.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
 

public class PrintFunction extends HttpServlet {
	static { System.setProperty("java.awt.headless", "true"); } 
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("PrintFunction - the function started");
        // set header as pdf
        response.setContentType("application/pdf");
        String fileName = request.getParameter("filename");
        System.out.println(fileName);
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        
        
        // get icons and pdf folders
        ServletContext context = getServletContext();
        String iconLocation = context.getRealPath("/icons");
        String reportLocation = context.getRealPath("/pdf");
        //String tmpLocation = context.getRealPath("/tmp");
        String tmpLocation = "/tmp";
        System.out.println("PrintFunction - directories mapped: " + iconLocation);
        System.out.println("PrintFunction - directories mapped: " + reportLocation);
        System.out.println("PrintFunction - directories mapped: " + tmpLocation);
        
        
        // list all objects and parameters
        List<Map<String, ?>> objectMap = new ArrayList<Map<String, ?>> ();
        Map<String,Object> map = new HashMap<String, Object>();
        
        for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            String name = entry.getKey();
            String value = request.getParameter(name);
            if (value.startsWith("icons")) {
            	if (value.lastIndexOf("*") > -1) {
	            	String nameP = name + "P";
	            	String valueP = iconLocation + value.substring(5);
	            	valueP = valueP.substring(0,valueP.lastIndexOf("*"));
	            	value = value.substring(value.lastIndexOf("*") + 1);
	            	map.put(nameP, valueP);
            	} else {value = iconLocation + value.substring(5);}
            }
            if (value.startsWith("tmp")) {
            	if (value.lastIndexOf("*") > -1) {
	            	String nameP = name + "P";
	            	value = tmpLocation + value.substring(3);
	            	String valueP = value.substring(0,value.lastIndexOf("*"));
	            	value = value.substring(value.lastIndexOf("*") + 1);
	            	map.put(nameP, valueP);
	            	
	            	System.out.println("PrintFunction - picture: " + valueP);
	            	if (new File(valueP).isFile()) {
	            		System.out.println("PrintFunction - picture: the file exists.");
	            	} else {
	            		System.out.println("PrintFunction - picture: the file doesn't exist.");
	            	}
	            	if (new File(valueP).canRead()) {
	            		System.out.println("PrintFunction - picture: the file can be read.");
	            	} else {
	            		System.out.println("PrintFunction - picture: the file can't be read.");
	            	}
	            	
	            	System.out.println("PrintFunction - caption: " + value);
            	}
            }
            if (value.startsWith("http")) {
            	String nameP = name + "P";
            	String valueP = value.substring(0,value.lastIndexOf("*"));
            	value = value.substring(value.lastIndexOf("*") + 1);
            	map.put(nameP, valueP);
            	System.out.println("PrintFunction - picture (URL): " + valueP);
            	System.out.println("PrintFunction - caption: " + value);
            }
            map.put(name, value);
        }
        objectMap.add(map);
        
 
        // set input and output stream
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis;
        BufferedInputStream bufferedInputStream;
 
        
        try {
            // get report
            fis = new FileInputStream(reportLocation + "/asmm_report_template.jasper");
            bufferedInputStream = new BufferedInputStream(fis);
            System.out.println("PrintFunction - template loaded");
            
 
            // fill it
            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(objectMap);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), dataSource);
            System.out.println("PrintFunction - data parsed in report");
 
            
            // export to pdf
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            response.setContentLength(baos.size());
            baos.writeTo(servletOutputStream);
            System.out.println("PrintFunction - report ready to be exported");
 
            
            // close it
            fis.close();
            bufferedInputStream.close();
 
        } catch (Exception ex) {
        	System.out.println("A problem occured during PDF rendition: " + ex);
            
        } finally {
            servletOutputStream.flush();
            servletOutputStream.close();
            baos.close();
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    
    @Override
    public String getServletInfo() {
        return "Reporting Servlet";
    }
}
/*package com.eufar.asmm.server;



import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gwt.user.client.Window;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
 
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
 
*//**
 *
 * @author edw
 *//*
public class PrintFunction extends HttpServlet {
 
	static { System.setProperty("java.awt.headless", "true"); } 
    *//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // set header as pdf
        response.setContentType("application/pdf");
        
 
        // set input and output stream
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis;
        BufferedInputStream bufferedInputStream;
 
        try {
            // get report location
            ServletContext context = getServletContext();
            String reportLocation = context.getRealPath("WEB-INF");
 
            // get report
            fis = new FileInputStream(reportLocation + "/Blank_A4.jasper");
            System.out.println("Fichier jasper ... OK");
            bufferedInputStream = new BufferedInputStream(fis);
            System.out.println("Buffer ... OK");
 
            // fetch data from database
            //Session session = HibernateUtil.getSessionFactory().openSession();
            //List<Master> masters = (List<Master>) session.createCriteria(Master.class).list();
            //session.close();
 
            // log it
            //for (Master master : masters) {
            //    logger.debug(master.toString());
            //}
 
            // fill it
            JREmptyDataSource test1 = new JREmptyDataSource(5);
            System.out.println("Empty Data Source ... OK");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(bufferedInputStream);
            System.out.println("Buffer loading ... OK");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, test1);
            System.out.println("Report generation ... OK");
 
            
            
            // export to pdf
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            System.out.println("Report print ... OK");
            
 
            //response.setContentLength(baos.size());
            //System.out.println("setContentLength ... OK");
            
            baos.writeTo(servletOutputStream);
            System.out.println("writeTo ... OK");
 
            // close it
            fis.close();
            bufferedInputStream.close();
 
        } catch (Exception ex) {
        	//Window.alert("problème");
        	System.out.println("problème");
            
        } finally {
            servletOutputStream.flush();
            servletOutputStream.close();
            baos.close();
            System.out.println("Nettoyage ... OK");
        }
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("doGet ... OK");
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        System.out.println("doPost ... OK");
    }
 
    @Override
    public String getServletInfo() {
        return "Reporting Servlet";
    }
}

public class PrintFunction extends HttpServlet {

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException
		  {
		    ServletOutputStream servletOutputStream = response.getOutputStream();
		    File reportFile = new File(getServletConfig().getServletContext()
		        .getRealPath("Blank_A4.jasper"));
		    byte[] bytes = null;

		    try
		    {
		      bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),
		          new HashMap(), new JREmptyDataSource());

		      response.setContentType("application/pdf");
		      response.setContentLength(bytes.length);

		      servletOutputStream.write(bytes, 0, bytes.length);
		      servletOutputStream.flush();
		      servletOutputStream.close();
		    }
		    catch (JRException e)
		    {
		      // display stack trace in the browser
		      StringWriter stringWriter = new StringWriter();
		      PrintWriter printWriter = new PrintWriter(stringWriter);
		      e.printStackTrace(printWriter);
		      response.setContentType("text/plain");
		      response.getOutputStream().print(stringWriter.toString());
		    }
		  }
}*/
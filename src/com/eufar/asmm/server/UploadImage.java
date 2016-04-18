/***LICENSE START
 * Copyright 2011 EUROPEAN UNION
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * 
 * Date: 03 January 2011
 * Authors: Marzia Grasso, Angelo Quaglia, Massimo Craglia
LICENSE END***/

package com.eufar.asmm.server;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


@SuppressWarnings("hiding")
public class UploadImage<FileItem> extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1546989855214562L;
	private static final String DATA_DIRECTORY = "/tmp";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 5;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 5;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UploadImage - the function started");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MAX_MEMORY_SIZE);
        String uploadFolder = getServletContext().getRealPath("") + DATA_DIRECTORY;
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		double maxSize = (MAX_REQUEST_SIZE / 1024) / 1024;
		System.out.println("UploadImage - max image size: " + maxSize + " Mbytes");
		try {
			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			@SuppressWarnings("rawtypes")
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				Object obj = iter.next();
				org.apache.commons.fileupload.FileItem item = (org.apache.commons.fileupload.FileItem)obj;
				String fileExt = FilenameUtils.getExtension(item.getName());
				if (fileExt.matches("(jpg|jpeg|bmp|png|JPG|JPEG|BMP|PNG)")) {
						System.out.println("UploadImage - image accepted");
						if (!item.isFormField()) {
		                    File uploadedFile = File.createTempFile("tmp_", "." + fileExt, new File(uploadFolder));
		                    item.write(uploadedFile);
		                    double fileSize = item.getSize();
		                    fileSize = (fileSize / 1024) / 1024;
		                    response.setCharacterEncoding("UTF-8");
							response.setContentType("text/html");
							response.getWriter().write(uploadedFile.getName());
							System.out.println("UploadImage - " + uploadedFile.getPath() + ": upload ok...");
							System.out.println("UploadImage - " + uploadedFile.getPath() + ": " + fileSize + " MBytes");
							if (new File(uploadedFile.getPath()).isFile()) {
			            		System.out.println("PrintFunction - picture (webapps): the file exists.");
			            	} else {
			            		System.out.println("PrintFunction - picture (webapps): the file doesn't exist.");
			            	}
			            	if (new File(uploadedFile.getPath()).isFile()) {
			            		System.out.println("PrintFunction - picture (webapps): the file can be read.");
			            	} else {
			            		System.out.println("PrintFunction - picture (webapps): the file can't be read.");
			            	}
		                } else {
		                	System.out.println("UploadImage - a problem occured with the file format");
		                }
				} else {
					System.out.println("UploadImage - image rejected: wrong format");
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html");
					response.getWriter().write("format");
				}
			}
		} catch (Exception ex) {
			System.out.println("UploadImage - a problem occured: " + ex);
			response.getWriter().write("ERROR:" + ex.getMessage());
		}
	}	
}
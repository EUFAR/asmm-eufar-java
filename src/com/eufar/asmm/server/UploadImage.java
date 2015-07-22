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

@SuppressWarnings("hiding")
public class UploadImage<FileItem> extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private static final String DATA_DIRECTORY = "tmp";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 5;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 5;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MAX_MEMORY_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        String uploadFolder = getServletContext().getRealPath("") + File.separator + DATA_DIRECTORY;
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		double maxSize = (MAX_REQUEST_SIZE / 1024) / 1024;
		System.out.println("Max image size: " + maxSize + " Mbytes");
		try {
			List items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while(iter.hasNext()){
				Object obj = iter.next();
				org.apache.commons.fileupload.FileItem item = (org.apache.commons.fileupload.FileItem)obj;
				if (!item.isFormField()) {
                    File uploadedFile = File.createTempFile("tmp_", ".jpg", new File(uploadFolder));
                    uploadedFile.deleteOnExit();
                    item.write(uploadedFile);
                    double fileSize = item.getSize();
                    fileSize = (fileSize / 1024) / 1024;
                    response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html");
					response.getWriter().write(uploadedFile.getName());
					System.out.println(uploadedFile.getName() + ": upload ok...");
					System.out.println(uploadedFile.getName() + ": " + fileSize + " MBytes");
                } else {
                	System.out.println("error");
                }
			}
		} catch (Exception ex) {
			System.out.println(ex);
			response.getWriter().write("ERROR:" + ex.getMessage());
		}
	}	
}
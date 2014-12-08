package com.innovez.learn.web;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.innovez.learn.backend.FileDescriptor;
import com.innovez.learn.backend.FileService;

/**
 * Controller for handling file download.
 * 
 * @author zakyalvan
 */
public class DownloadController extends AbstractController {
	private static final Logger LOGGER = Logger.getLogger(DownloadController.class);
	
	private FileService fileService;
	
	public DownloadController(FileService fileService) {
		Assert.notNull(fileService);
		this.fileService = fileService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.debug("Handle download file.");
		
		Long fileId = Long.parseLong(request.getParameter("file"));
		
		FileDescriptor descriptor = fileService.getFile(fileId);
		
		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + descriptor.getName() + "\"");   
		
		FileInputStream inputStream = new FileInputStream(descriptor.getPath());
		byte[] buffer = new byte[128];
		int result = -1;
		while((result = inputStream.read(buffer)) != -1) {
			response.getOutputStream().write(buffer);
		}
		inputStream.close();
		
		return null;
	}
}

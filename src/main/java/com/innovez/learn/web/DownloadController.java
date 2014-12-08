package com.innovez.learn.web;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
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
		Assert.notNull(fileService, "File service parameter must not be null");
		this.fileService = fileService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.debug("Handle download file.");
		
		Long fileId = Long.parseLong(request.getParameter("file"));
		if(!fileService.fileExists(fileId)) {
			LOGGER.error(String.format("File with id %d not found, return not found code", fileId));
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		FileDescriptor descriptor = fileService.getFile(fileId);
		
		String mimeType = descriptor.getContentType();
		if(!StringUtils.hasText(mimeType)) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		
		File file = new File(descriptor.getPath());
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition","attachment; filename=\"" + descriptor.getName() + "\"");   
		
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		while(fileInputStream.read(buffer) != -1) {
			response.getOutputStream().write(buffer);
		}
		fileInputStream.close();
		
		return null;
	}
}

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
public class RemoveController extends AbstractController {
	private static final Logger LOGGER = Logger.getLogger(RemoveController.class);
	
	private FileService fileService;
	
	public RemoveController(FileService fileService) {
		Assert.notNull(fileService);
		this.fileService = fileService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.debug("Handle download file.");
		Long fileId = Long.parseLong(request.getParameter("file"));
		
		if(!fileService.fileExists(fileId)) {
			LOGGER.debug(String.format("File with id %d not found", fileId));
		}
		
		fileService.removeFile(fileId);
		return new ModelAndView("redirect:/list");
	}
}

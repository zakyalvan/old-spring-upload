package com.innovez.learn.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.innovez.learn.backend.FileService;

public class ListController extends AbstractController {
	private static final Logger LOGGER = Logger.getLogger(ListController.class);
	
	private FileService fileService;
	
	public ListController(FileService fileService) {
		Assert.notNull(fileService);
		this.fileService = fileService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.debug("Handle show uploaded files list request");
		return new ModelAndView("list", "files", fileService.getFiles());
	}

}

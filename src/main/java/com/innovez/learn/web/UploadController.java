package com.innovez.learn.web;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.innovez.learn.backend.FileDescriptor;
import com.innovez.learn.backend.FileService;

/**
 * Simple controller for handling file upload.
 * 
 * @author zakyalvan
 */
public class UploadController extends SimpleFormController {
	private static final Logger LOGGER = Logger.getLogger(UploadController.class.getName());
	
	private FileService fileService;
	
	public UploadController(FileService fileService) {
		Assert.notNull(fileService, "File service parameter must not be null");
		this.fileService = fileService;
		
		setCommandClass(UploadForm.class);
		setCommandName("fileUpload");
	}
	
	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		LOGGER.debug("Init controller binder");
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		LOGGER.log(Level.INFO, "Handle file upload form submission");
		if(errors.hasErrors()) {
			LOGGER.error(String.format("Submission contains errors, reject submissions %s", errors.toString()));
			return new ModelAndView("upload");
		}
		
		UploadForm uploadForm = (UploadForm) command;
		String name = uploadForm.getName();
		String description = uploadForm.getDescription();
		
		MultipartFile multipartFile = uploadForm.getFile();
		if(!StringUtils.hasText(name)) {
			name = multipartFile.getOriginalFilename();
		}
		
		String contentType = multipartFile.getContentType();
		
		File file = File.createTempFile("uploaded_", ".file.tmp");
		
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(multipartFile.getBytes());
		outputStream.flush();
		outputStream.close();
		
		FileDescriptor descriptor = fileService.storeFile(file, name, contentType, description);
		return new ModelAndView("success", "file", descriptor);
	}
}

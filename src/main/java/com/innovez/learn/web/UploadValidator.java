package com.innovez.learn.web;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Utility type for validating uploaded files.
 * 
 * @author zakyalvan
 */
public class UploadValidator implements Validator {
	public boolean supports(Class clazz) {
		return UploadForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UploadForm form = (UploadForm) target;
		if (form.getFile() != null && form.getFile().getSize() == 0) {
			errors.rejectValue("file", "required.file");
		}
	}
}
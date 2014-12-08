package com.innovez.learn.backend;

import java.io.File;
import java.util.Collection;

/**
 * Contract for service object handling file persitence and retrieval.
 * 
 * @author zakyalvan
 */
public interface FileService {
	FileDescriptor storeFile(File file, String name, String contentType, String description);
	Collection<FileDescriptor> getFiles();
	boolean fileExists(Long id);
	FileDescriptor getFile(Long id);
	void removeFile(Long fileId);
}

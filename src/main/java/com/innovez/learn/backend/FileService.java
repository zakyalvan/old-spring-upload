package com.innovez.learn.backend;

import java.io.File;
import java.util.Collection;

public interface FileService {
	void storeFile(FileDescriptor descriptor, File file);
	Collection<FileDescriptor> getFiles();
	boolean fileExists(Long id);
	FileDescriptor getFile(Long id);
	void removeFile(Long fileId);
}

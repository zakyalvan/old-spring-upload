package com.innovez.learn.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Simple implementation of {@link FileService}. Store file descriptor in memory.
 * 
 * @author zakyalvan
 */
public class InMemoryFileService implements FileService {
	private static final Logger LOGGER = Logger.getLogger(InMemoryFileService.class);
	
	/**
	 * File descriptor storage.
	 */
	private Map<Long, FileDescriptor> memoryStorages = new HashMap<Long, FileDescriptor>();
	
	public FileDescriptor storeFile(File file, String name, String contentType, String description) {
		LOGGER.debug("Store file");
		FileDescriptor descriptor = new FileDescriptor(name, contentType, description, file.getAbsolutePath(), new Date());
		memoryStorages.put(descriptor.getId(), descriptor);
		return descriptor;
	}

	public Collection<FileDescriptor> getFiles() {
		LOGGER.debug("Retrieve all files");
		return new ArrayList<FileDescriptor>(memoryStorages.values());
	}

	public boolean fileExists(Long id) {
		LOGGER.debug("Ask whether file exists");
		return memoryStorages.containsKey(id);
	}

	public FileDescriptor getFile(Long id) {
		LOGGER.debug("Retrieve one file");
		return memoryStorages.get(id);
	}

	public void removeFile(Long fileId) {
		if(fileExists(fileId)) {
			memoryStorages.remove(fileId);
		}
	}
}

package com.innovez.learn.backend;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

public class InMemoryFileService implements FileService {
	private static final Logger LOGGER = Logger.getLogger(InMemoryFileService.class);
	
	/**
	 * File descriptor storage.
	 */
	private Map<Long, FileDescriptor> memoryStorages = new HashMap<Long, FileDescriptor>();
	
	public void storeFile(FileDescriptor descriptor, File file) {
		LOGGER.debug(String.format("Handle store file : %s", descriptor));
		/**
		 * TODO
		 * 
		 * Add validation on descriptor against file.
		 */
		memoryStorages.put(descriptor.getId(), descriptor);
	}

	public Collection<FileDescriptor> getFiles() {
		return memoryStorages.values();
	}

	public boolean fileExists(Long id) {
		return memoryStorages.containsKey(id);
	}

	public FileDescriptor getFile(Long id) {
		return memoryStorages.get(id);
	}

	public void removeFile(Long fileId) {
		memoryStorages.remove(fileId);
	}
}

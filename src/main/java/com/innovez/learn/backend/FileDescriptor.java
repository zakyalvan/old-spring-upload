package com.innovez.learn.backend;

import java.io.Serializable;
import java.util.Date;

/**
 * Simple descriptor of file, you can imagine this type as database row or record.
 * 
 * @author zakyalvan
 */
@SuppressWarnings("serial")
public class FileDescriptor implements Serializable {
	private final Long id;
	private final String name;
	private final String contentType;
	private final String description;
	private final String path;
	private final Date uploadTimestamp;
	
	public FileDescriptor(String name, String contentType, String description, String path, Date uploadTimestamp) {
		this.id = new Long(new Date().getTime());
		this.name = name;
		this.contentType = contentType;
		this.description = description;
		this.path = path;
		this.uploadTimestamp = uploadTimestamp;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getContentType() {
		return contentType;
	}
	public String getDescription() {
		return description;
	}
	public String getPath() {
		return path;
	}
	public Date getUploadTimestamp() {
		return uploadTimestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileDescriptor other = (FileDescriptor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileDescriptor [id=" + id + ", name=" + name + ", contentType="
				+ contentType + ", description=" + description + ", path="
				+ path + ", uploadTimestamp=" + uploadTimestamp + "]";
	}	
}

package com.innovez.learn.backend;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class FileDescriptor implements Serializable {
	private final Long id;
	private final String name;
	private final String path;
	private final Date uploadTimestamp;
	
	public FileDescriptor(String name, String path, Date uploadTimestamp) {
		this.id = new Long(new Date().getTime());
		this.name = name;
		this.path = path;
		this.uploadTimestamp = uploadTimestamp;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
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
		return "FileDescriptor [id=" + id + ", name=" + name + ", path=" + path
				+ ", uploadTimestamp=" + uploadTimestamp + "]";
	}
}

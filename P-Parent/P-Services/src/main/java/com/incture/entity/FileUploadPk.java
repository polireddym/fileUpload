package com.incture.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FileUploadPk implements Serializable,BaseDo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name="FILE_VERSION")
	private String fileVersion;

	public FileUploadPk() {
		super();
	}


	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "FileUploadPk [fileType=" + fileType + ", fileVersion=" + fileVersion + "]";
	}


	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}

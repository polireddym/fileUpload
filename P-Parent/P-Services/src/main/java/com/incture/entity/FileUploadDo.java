package com.incture.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="FILE_UPLOAD")		
public class FileUploadDo implements BaseDo,Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private FileUploadPk pk;
	
	@Column(name ="FILE_NAME")	
	private String fileName;	
	
	@Lob
	@Column(name="FILE_DATA")	
	private byte[] fileData;

	

	public FileUploadDo() {
		super();
	}

	public FileUploadPk getPk() {
		return pk;
	}



	public void setPk(FileUploadPk pk) {
		this.pk = pk;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public byte[] getFileData() {
		return fileData;
	}



	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "FileUploadDo [pk=" + pk + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData) + "]";
	}



	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}	

}

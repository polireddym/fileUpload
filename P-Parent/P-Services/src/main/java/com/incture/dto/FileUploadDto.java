package com.incture.dto;

import java.util.Arrays;

import com.incture.exception.InvalidInputFault;
import com.incture.util.EnOperation;

public class FileUploadDto extends BaseDto {
	
	
    private String fileName;	
	
	private byte[] fileData;
	
	private String  fileVersion;
	
	private String fileType;

	private String id;
	

	

	public FileUploadDto() {
		super();
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

	public String getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(String fileVersion) {
		this.fileVersion = fileVersion;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FileUploadDto [fileName=" + fileName + ", fileData=" + Arrays.toString(fileData) + ", fileVersion="
				+ fileVersion + ", fileType=" + fileType + ", id=" + id + "]";
	}

	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(EnOperation enOperation) throws InvalidInputFault {
		// TODO Auto-generated method stub
		
	}

}

package com.incture.services;


import com.incture.dto.FileUploadDto;
import com.incture.dto.ResponseMessage;

public interface FileUploadFacadeLocal {	
	public ResponseMessage saveFile(FileUploadDto dto);
    public FileUploadDto retriveFile(String fileType,String fileVersion);
}

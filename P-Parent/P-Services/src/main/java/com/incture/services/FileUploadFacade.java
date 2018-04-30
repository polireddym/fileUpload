package com.incture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dao.FileUploadDao;
import com.incture.dto.FileUploadDto;
import com.incture.dto.ResponseMessage;

@Service 
public class FileUploadFacade implements FileUploadFacadeLocal {

	@Autowired
	private FileUploadDao dao;

	@Override
	public ResponseMessage saveFile(FileUploadDto dto) {		
		return dao.saveFile(dto);
	}
	@Override
	public FileUploadDto retriveFile(String fileType,String fileVersion) {		
		return dao.retriveFile(fileType, fileVersion);	
}
}

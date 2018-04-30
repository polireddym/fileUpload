package com.incture.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.incture.dto.FileUploadDto;
import com.incture.dto.ResponseMessage;
import com.incture.services.FileUploadFacadeLocal;
import com.incture.util.ServicesUtil;


@RestController
@RequestMapping(value="/file")
public class FileUploadRest {

	@Autowired
	private FileUploadFacadeLocal service;

	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	public ResponseMessage saveFile(@RequestParam("file")CommonsMultipartFile cmf,@RequestParam("fileVersion")String fileVersion,@RequestParam("fileType")String fileType ){

		FileUploadDto dto=new FileUploadDto();
		dto.setFileVersion(fileVersion);
		dto.setFileType(fileType.toLowerCase());
		dto.setFileName(ServicesUtil.removeExtension(cmf.getOriginalFilename()));
		dto.setFileData(cmf.getBytes());

		return service.saveFile(dto);
	}

	@RequestMapping(value="/downloadFile/{fileType}/{fileVersion:.*}",method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse res,@PathVariable("fileType")String fileType,@PathVariable("fileVersion")String fileVersion){

		
		FileUploadDto dt=service.retriveFile(fileType.toLowerCase(),fileVersion);
		res.addHeader("Content-Disposition", "attachment;filename="+dt.getFileName()+"."+dt.getFileType());
		try {
			FileCopyUtils.copy(dt.getFileData(), res.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
package com.incture.dao;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.dto.FileUploadDto;
import com.incture.dto.ResponseMessage;
import com.incture.entity.FileUploadDo;
import com.incture.entity.FileUploadPk;
import com.incture.exception.ExecutionFault;
import com.incture.exception.InvalidInputFault;
import com.incture.exception.NoResultFault;
import com.incture.util.ServicesUtil;
@Repository("FileUploadDao")
@Transactional
public class FileUploadDao extends BaseDao<FileUploadDo, FileUploadDto>{

	// private static final Logger logger = LoggerFactory.getLogger("FileUploadDao");
	@Override
	protected FileUploadDo importDto(FileUploadDto fromDto) throws InvalidInputFault, ExecutionFault, NoResultFault {
		FileUploadDo entity=new FileUploadDo();
		FileUploadPk entityPk=new FileUploadPk();
		
		if (!ServicesUtil.isEmpty(fromDto.getFileType()))
			entityPk.setFileType(fromDto.getFileType());
		if (!ServicesUtil.isEmpty(fromDto.getFileVersion()))
			entityPk.setFileVersion(fromDto.getFileVersion());

		entity.setPk(entityPk);

		if (!ServicesUtil.isEmpty(fromDto.getFileName()))
			entity.setFileName(fromDto.getFileName());

		if (!ServicesUtil.isEmpty(fromDto.getFileData()))
			entity.setFileData(fromDto.getFileData());

		return entity;
	}

	@Override
	protected FileUploadDto exportDto(FileUploadDo entity) {
		FileUploadDto dto=new FileUploadDto();
		FileUploadPk entityPk=new FileUploadPk();		

		if (!ServicesUtil.isEmpty(entity.getFileName()))
			dto.setFileName(entity.getFileName());

		if (!ServicesUtil.isEmpty(entity.getFileData()))
			dto.setFileData(entity.getFileData());

		entityPk= entity.getPk();

		if(!ServicesUtil.isEmpty(entityPk.getFileType()))
			dto.setFileType(entityPk.getFileType());

		if (!ServicesUtil.isEmpty(entityPk.getFileVersion()))
			dto.setFileVersion(entityPk.getFileVersion());

		return dto;
	}

	public ResponseMessage saveFile(FileUploadDto dto){

		ResponseMessage responseMessage=new ResponseMessage();
		responseMessage.setMessage("failur");
		responseMessage.setStatus("false");
		responseMessage.setStatusCode("0"); 
      
		try {
			getSession().save(importDto(dto));
			responseMessage.setMessage("success");
			responseMessage.setStatus("true");
			responseMessage.setStatusCode("1");
			//logger.info("[web]succesfully saved");
           
		} catch (ExecutionFault e) {
			e.printStackTrace();
		} catch (InvalidInputFault e) {
			e.printStackTrace();
		} catch (NoResultFault e) {
			e.printStackTrace();
		}

		return responseMessage;
	}
	public FileUploadDto retriveFile(String fileType,String fileVersion ) {		

		Query q=getSession().createQuery("from com.incture.entity.FileUploadDo where pk.fileType=:fileType and pk.fileVersion=:fileVersion");;
		q.setParameter("fileType",fileType);
		q.setParameter("fileVersion",fileVersion);
		return exportDto((FileUploadDo) q.uniqueResult());
	}

}

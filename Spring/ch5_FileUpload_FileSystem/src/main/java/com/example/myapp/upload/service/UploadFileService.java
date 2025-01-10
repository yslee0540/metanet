package com.example.myapp.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.upload.dao.IUploadFileRepository;
import com.example.myapp.upload.model.UploadFile;

@Service
public class UploadFileService implements IUploadFileService {
	
	@Autowired
	IUploadFileRepository uploadFileRepository;

	@Override
	public void uploadFile(UploadFile file) {
		int fileId = uploadFileRepository.getMaxFileId();
		file.setFileId(fileId + 1);
		uploadFileRepository.uploadFile(file);
	}

	@Override
	public List<UploadFile> getAllFileList() {
		return uploadFileRepository.getAllFileList();
	}

	@Override
	public UploadFile getFile(int fileId) {
		return uploadFileRepository.getFile(fileId);
	}

	@Override
	public void deleteFile(int fileId) {
		uploadFileRepository.deleteFile(fileId);
	}

	@Override
	public String getUuidFileName(int fileId) {
		return uploadFileRepository.getUuidFIleName(fileId);
	}

}

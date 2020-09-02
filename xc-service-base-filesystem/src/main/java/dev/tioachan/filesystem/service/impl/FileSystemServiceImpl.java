package dev.tioachan.filesystem.service.impl;

import com.alibaba.fastjson.JSON;
import dev.tioachan.filesystem.dao.FileSystemRepository;
import dev.tioachan.filesystem.service.FileSystemService;
import dev.tioachan.filesystem.utils.FastDFSClient;
import dev.tioachan.framework.domain.filesystem.FileSystem;
import dev.tioachan.framework.domain.filesystem.response.FileSystemCode;
import dev.tioachan.framework.domain.filesystem.response.UploadFileResult;
import dev.tioachan.framework.exception.ExceptionCast;
import dev.tioachan.framework.model.response.CommonCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class FileSystemServiceImpl implements FileSystemService {

	@Autowired
	private FileSystemRepository fileSystemRepository;

	@Autowired
	private FastDFSClient fastDFSClient;

	@Override
	public UploadFileResult upload(MultipartFile multipartFile, String fileTag, String businessKey, String metadata) {
		if(multipartFile ==null){
			ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_FILEISNULL);
		}
		//第一步：将文件上传到fastDFS中，得到一个文件id
		String fileId = null;
		try {
			fileId = fastDFSClient.uploadFile(multipartFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(StringUtils.isEmpty(fileId)){
			ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
		}
		//第二步：将文件id及其它文件信息存储到mongodb中。
		FileSystem fileSystem = new FileSystem();
		fileSystem.setFileId(fileId);
		fileSystem.setFilePath(fileId);
		fileSystem.setFileTag(fileTag);
		fileSystem.setBusinessKey(businessKey);
		fileSystem.setFileName(multipartFile.getOriginalFilename());
		fileSystem.setFileType(multipartFile.getContentType());
		if(StringUtils.isNotEmpty(metadata)){
			try {
				Map map = JSON.parseObject(metadata, Map.class);
				fileSystem.setMetadata(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		fileSystemRepository.save(fileSystem);
		return new UploadFileResult(CommonCode.SUCCESS,fileSystem);
	}
}

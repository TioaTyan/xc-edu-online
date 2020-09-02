package dev.tioachan.filesystem.service;

import dev.tioachan.framework.domain.filesystem.response.UploadFileResult;
import org.springframework.web.multipart.MultipartFile;

public interface FileSystemService {
	UploadFileResult upload(MultipartFile multipartFile, String fileTag, String businessKey, String metadata);
}

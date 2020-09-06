package dev.tioachan.filesystem.controller;

import dev.tioachan.api.filesystem.FileSystemControllerApi;
import dev.tioachan.filesystem.service.FileSystemService;
import dev.tioachan.framework.domain.filesystem.response.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi {
	@Autowired
	FileSystemService fileSystemService;

	@PostMapping("/upload")
	@Override
	public UploadFileResult upload(MultipartFile file, String fileTag, String businessKey, String metadata) {
		return fileSystemService.upload(file, fileTag, businessKey, metadata);
	}
}

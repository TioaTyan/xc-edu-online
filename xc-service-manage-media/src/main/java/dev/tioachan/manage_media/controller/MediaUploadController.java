package dev.tioachan.manage_media.controller;

import dev.tioachan.api.media.MediaUploadControllerApi;
import dev.tioachan.framework.domain.media.response.CheckChunkResult;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.manage_media.service.MediaUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

public class MediaUploadController implements MediaUploadControllerApi {
	@Autowired
	MediaUploadService mediaUploadService;

	//文件上传前的注册
	@Override
	@PostMapping("/register")
	public ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
		return mediaUploadService.register(fileMd5, fileName, fileSize, mimetype, fileExt);
	}

	@Override
	@PostMapping("/checkChunk")
	public CheckChunkResult checkChunk(String fileMd5, Integer chunk, Integer chunkSize) {
		return mediaUploadService.checkChunk(fileMd5, chunk, chunkSize);
	}

	@Override
	@PostMapping("/uploadChunk")
	public ResponseResult uploadChunk(MultipartFile file, String fileMd5, Integer chunk) {
		return mediaUploadService.uploadChunk(file, fileMd5, chunk);
	}

	@Override
	@PostMapping("/mergeChunks")
	public ResponseResult mergeChunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
		return mediaUploadService.mergeChunks(fileMd5, fileName, fileSize, mimetype, fileExt);
	}
}

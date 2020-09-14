package dev.tioachan.manage_media.service.impl;

import dev.tioachan.framework.domain.media.response.CheckChunkResult;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.manage_media.service.MediaUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MediaUploadServiceImpl implements MediaUploadService {
	@Override
	public ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
		return null;
	}

	@Override
	public CheckChunkResult checkChunk(String fileMd5, Integer chunk, Integer chunkSize) {
		return null;
	}

	@Override
	public ResponseResult uploadChunk(MultipartFile file, String fileMd5, Integer chunk) {
		return null;
	}

	@Override
	public ResponseResult mergeChunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
		return null;
	}
}

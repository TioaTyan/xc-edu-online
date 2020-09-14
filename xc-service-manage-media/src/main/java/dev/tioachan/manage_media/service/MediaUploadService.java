package dev.tioachan.manage_media.service;

import dev.tioachan.framework.domain.media.response.CheckChunkResult;
import dev.tioachan.framework.model.response.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface MediaUploadService {
	ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt);

	CheckChunkResult checkChunk(String fileMd5, Integer chunk, Integer chunkSize);

	ResponseResult uploadChunk(MultipartFile file, String fileMd5, Integer chunk);

	ResponseResult mergeChunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt);
}

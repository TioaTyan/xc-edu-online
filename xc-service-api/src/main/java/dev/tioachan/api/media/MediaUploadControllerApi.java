package dev.tioachan.api.media;

import dev.tioachan.framework.domain.media.response.CheckChunkResult;
import dev.tioachan.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

@Api("媒体上传")
public interface MediaUploadControllerApi {
	ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt);
	CheckChunkResult checkChunk(String fileMd5, Integer chunk, Integer chunkSize);
	ResponseResult uploadChunk(MultipartFile file, String fileMd5, Integer chunk);
	ResponseResult mergeChunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt);
}

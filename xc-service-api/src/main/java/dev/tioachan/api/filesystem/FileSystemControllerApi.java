package dev.tioachan.api.filesystem;


import dev.tioachan.framework.domain.filesystem.response.UploadFileResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "文件系统接口")
public interface FileSystemControllerApi {

	@ApiOperation(value = "上传")
	UploadFileResult upload(MultipartFile multipartFile, String fileTag, String businessKey, String metadata);
}

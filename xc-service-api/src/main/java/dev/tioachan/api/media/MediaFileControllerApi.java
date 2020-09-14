package dev.tioachan.api.media;

import dev.tioachan.framework.domain.media.MediaFile;
import dev.tioachan.framework.domain.media.request.QueryMediaFileRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;

@Api("媒体资源文件")
public interface MediaFileControllerApi {
	QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest);
}

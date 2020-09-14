package dev.tioachan.manage_media.service;

import dev.tioachan.framework.domain.media.MediaFile;
import dev.tioachan.framework.domain.media.request.QueryMediaFileRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;

public interface MediaFileService {
	QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest);

}

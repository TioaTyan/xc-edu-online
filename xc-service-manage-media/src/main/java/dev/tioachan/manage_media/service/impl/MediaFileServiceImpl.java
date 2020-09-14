package dev.tioachan.manage_media.service.impl;

import dev.tioachan.framework.domain.media.MediaFile;
import dev.tioachan.framework.domain.media.request.QueryMediaFileRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_media.service.MediaFileService;
import org.springframework.stereotype.Service;

@Service
public class MediaFileServiceImpl implements MediaFileService {
	@Override
	public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) {
		return null;
	}
}

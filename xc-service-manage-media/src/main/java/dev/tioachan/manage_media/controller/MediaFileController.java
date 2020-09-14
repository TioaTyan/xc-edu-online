package dev.tioachan.manage_media.controller;

import dev.tioachan.api.media.MediaFileControllerApi;
import dev.tioachan.framework.domain.media.MediaFile;
import dev.tioachan.framework.domain.media.request.QueryMediaFileRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_media.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class MediaFileController implements MediaFileControllerApi {
	@Autowired
	MediaFileService mediaFileService;

	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) {
		return mediaFileService.findList(page,size,queryMediaFileRequest);
	}
}

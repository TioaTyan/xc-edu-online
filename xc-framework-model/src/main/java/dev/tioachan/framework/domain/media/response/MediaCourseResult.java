package dev.tioachan.framework.domain.media.response;

import dev.tioachan.framework.domain.media.MediaFile;
import dev.tioachan.framework.domain.media.MediaVideoCourse;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by admin on 2018/3/5.
 */
@Data
@ToString
@NoArgsConstructor
public class MediaCourseResult extends ResponseResult {
	MediaFile mediaVideo;
	MediaVideoCourse mediaVideoCourse;
	public MediaCourseResult(ResultCode resultCode, MediaVideoCourse mediaVideoCourse) {
		super(resultCode);
		this.mediaVideoCourse = mediaVideoCourse;
	}
}

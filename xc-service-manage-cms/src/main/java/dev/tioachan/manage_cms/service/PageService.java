package dev.tioachan.manage_cms.service;

import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.ResponseResult;

public interface PageService {
	QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

	ResponseResult addPage(CmsPage cmsPage);

	ResponseResult delPage(String pageId);

	ResponseResult updatePage(CmsPage cmsPage);

	CmsPage getPage(String pageId);

	String getPageHtml(String pageId);

}

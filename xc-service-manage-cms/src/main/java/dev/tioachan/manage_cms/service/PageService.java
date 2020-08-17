package dev.tioachan.manage_cms.service;

import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;

public interface PageService {
	QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}

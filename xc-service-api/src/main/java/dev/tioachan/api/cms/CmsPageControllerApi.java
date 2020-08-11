package dev.tioachan.api.cms;

import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;

public interface CmsPageControllerApi {

	QueryResponseResult findList(Integer page, Integer size, QueryPageRequest queryPageRequest);
}

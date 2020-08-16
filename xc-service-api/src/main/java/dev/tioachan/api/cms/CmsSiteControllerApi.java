package dev.tioachan.api.cms;

import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "CMS站点管理接口")
public interface CmsSiteControllerApi {
	@ApiOperation("获取CMS站点")
	QueryResponseResult findList();
}

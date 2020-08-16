package dev.tioachan.api.cms;

import dev.tioachan.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CMS模板管理接口")
public interface CmsTemplateControllerApi {
	@ApiOperation("获取CMS模板")
	QueryResponseResult findList();
}

package dev.tioachan.api.cms;
import dev.tioachan.framework.domain.cms.CmsConfig;
import dev.tioachan.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value="cms配置管理接口")
public interface CmsConfigControllerApi {
    @ApiOperation("根据id查询CMS配置信息")
    CmsConfig getmodel(String id);
    @ApiOperation("获取全部模型数据")
    QueryResponseResult findAll();
}
package dev.tioachan.api.course;

import dev.tioachan.framework.domain.system.SysDictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "数据字典接口", description = "提供数据字典接口的管理、查询功能")
public interface SysDictionaryControllerApi {
    //数据字典
    @ApiOperation(value = "数据字典查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, paramType = "path", dataType = "String")
    })
    public SysDictionary getByType(String type);
}

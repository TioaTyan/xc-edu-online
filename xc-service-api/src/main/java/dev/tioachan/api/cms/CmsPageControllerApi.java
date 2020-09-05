package dev.tioachan.api.cms;

import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "CMS页面管理接口")
public interface CmsPageControllerApi {
	@ApiOperation("分页查询页面列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
			@ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
	})
	QueryResponseResult findList(Integer page, Integer size, QueryPageRequest queryPageRequest);

	@ApiOperation("查找")
	CmsPage findById(String pageId);

	@ApiOperation("添加")
	ResponseResult add(CmsPage cmsPage);

	@ApiOperation("删除")
	ResponseResult delPage(String pageId);

	@ApiOperation("更新")
	ResponseResult updatePage(CmsPage cmsPage);
}

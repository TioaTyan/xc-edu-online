package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.cms.CmsPageControllerApi;
import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") Integer page, @PathVariable("size") Integer size, QueryPageRequest queryPageRequest) {
		CmsPage cmsPage=new CmsPage();
		cmsPage.setPageName("TestPage");

		List list=new ArrayList();
		list.add(cmsPage);

		QueryResult queryResult=new QueryResult();
		queryResult.setList(list);
		queryResult.setTotal(1);

		QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
		return queryResponseResult;
	}
}

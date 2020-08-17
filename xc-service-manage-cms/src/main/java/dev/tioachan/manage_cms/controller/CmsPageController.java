package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.cms.CmsPageControllerApi;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_cms.service.PageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
	final
	PageService pageServiceImpl;

	public CmsPageController(PageService pageServiceImpl) {
		this.pageServiceImpl = pageServiceImpl;
	}

	@Override
	@GetMapping("/list/{page}/{size}/")
	public QueryResponseResult findList(@PathVariable("page") Integer page,
										@PathVariable("size") Integer size,
										QueryPageRequest queryPageRequest) {
		return pageServiceImpl.findList(page, size, queryPageRequest);
	}
}

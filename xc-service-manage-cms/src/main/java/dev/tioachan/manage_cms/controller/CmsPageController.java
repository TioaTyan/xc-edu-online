package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.cms.CmsPageControllerApi;
import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.manage_cms.service.PageService;
import org.springframework.web.bind.annotation.*;

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

	@Override
	@GetMapping("/get/{id}")
	public CmsPage findById(@PathVariable("id") String pageId) {
		return pageServiceImpl.getPage(pageId);
	}

	@PostMapping("/add")
	public ResponseResult add(@RequestBody CmsPage cmsPage){
//		System.out.println(cmsPage);
		return pageServiceImpl.addPage(cmsPage);
	}

	@DeleteMapping("/del/{pageId}")
	public ResponseResult delPage(@PathVariable("pageId") String pageId){
//		System.out.println(cmsPage);
		return pageServiceImpl.delPage(pageId);
	}

	@PutMapping("/edit")
	public ResponseResult updatePage(@RequestBody CmsPage cmsPage){
		return pageServiceImpl.updatePage(cmsPage);
	}
}

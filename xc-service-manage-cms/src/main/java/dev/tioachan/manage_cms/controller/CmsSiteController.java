package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.cms.CmsSiteControllerApi;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_cms.service.PageService;
import dev.tioachan.manage_cms.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/site")
public class CmsSiteController implements CmsSiteControllerApi {
	@Autowired
	SiteService siteService;

	@Override
	@GetMapping("/list/")
	public QueryResponseResult findList() {
		return siteService.findList();
	}
}

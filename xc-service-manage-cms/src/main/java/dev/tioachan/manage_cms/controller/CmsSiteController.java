package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.cms.CmsSiteControllerApi;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_cms.service.SiteService;
import dev.tioachan.manage_cms.service.impl.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/site")
public class CmsSiteController implements CmsSiteControllerApi {
	final
	SiteService siteServiceImpl;

	public CmsSiteController(SiteService siteServiceImpl) {
		this.siteServiceImpl = siteServiceImpl;
	}

	@Override
	@GetMapping("/list/")
	public QueryResponseResult findList() {
		return siteServiceImpl.findList();
	}
}

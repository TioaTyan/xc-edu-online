package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.cms.CmsTemplateControllerApi;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_cms.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/template")
public class CmsTemplateController implements CmsTemplateControllerApi {
	@Autowired
	TemplateService templateService;

	@Override
	@GetMapping("/list/")
	public QueryResponseResult findList() {
		return templateService.findList();
	}
}

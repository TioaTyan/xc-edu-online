package dev.tioachan.manage_cms.service.impl;

import dev.tioachan.framework.domain.cms.CmsTemplate;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.manage_cms.dao.CmsTemplateRepository;
import dev.tioachan.manage_cms.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
	final
	CmsTemplateRepository cmsTemplateRepository;

	public TemplateServiceImpl(CmsTemplateRepository cmsTemplateRepository) {
		this.cmsTemplateRepository = cmsTemplateRepository;
	}

	public QueryResponseResult findList() {

		List<CmsTemplate> templateList = cmsTemplateRepository.findAll();
		QueryResult<CmsTemplate> cmsSiteQueryResult=new QueryResult<>();
		cmsSiteQueryResult.setList(templateList);
		cmsSiteQueryResult.setTotal(templateList.size());
		return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteQueryResult);
	}
}

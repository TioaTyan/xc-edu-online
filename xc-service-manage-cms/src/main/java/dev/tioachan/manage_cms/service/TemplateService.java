package dev.tioachan.manage_cms.service;

import dev.tioachan.framework.domain.cms.CmsSite;
import dev.tioachan.framework.domain.cms.CmsTemplate;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.manage_cms.dao.CmsSiteRepository;
import dev.tioachan.manage_cms.dao.CmsTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
	@Autowired
	CmsTemplateRepository cmsTemplateRepository;

	public QueryResponseResult findList() {

		List<CmsTemplate> templateList = cmsTemplateRepository.findAll();
		QueryResult<CmsTemplate> cmsSiteQueryResult=new QueryResult<>();
		cmsSiteQueryResult.setList(templateList);
		cmsSiteQueryResult.setTotal(templateList.size());
		return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteQueryResult);
	}
}

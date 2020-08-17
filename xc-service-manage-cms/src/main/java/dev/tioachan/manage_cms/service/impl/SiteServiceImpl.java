package dev.tioachan.manage_cms.service.impl;

import dev.tioachan.framework.domain.cms.CmsSite;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.manage_cms.dao.CmsSiteRepository;
import dev.tioachan.manage_cms.service.SiteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
	final
	CmsSiteRepository cmsSiteRepository;

	public SiteServiceImpl(CmsSiteRepository cmsSiteRepository) {
		this.cmsSiteRepository = cmsSiteRepository;
	}

	public QueryResponseResult findList() {
		List<CmsSite> siteList = cmsSiteRepository.findAll();
		QueryResult<CmsSite> cmsSiteQueryResult=new QueryResult<>();
		cmsSiteQueryResult.setList(siteList);
		cmsSiteQueryResult.setTotal(siteList.size());
		return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteQueryResult);
	}
}

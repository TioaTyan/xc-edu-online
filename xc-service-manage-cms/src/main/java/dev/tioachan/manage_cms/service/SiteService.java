package dev.tioachan.manage_cms.service;

import dev.tioachan.framework.domain.cms.CmsSite;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.manage_cms.dao.CmsSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
	@Autowired
	CmsSiteRepository cmsSiteRepository;

	public QueryResponseResult findList() {
		List<CmsSite> siteList = cmsSiteRepository.findAll();
		QueryResult<CmsSite> cmsSiteQueryResult=new QueryResult<>();
		cmsSiteQueryResult.setList(siteList);
		cmsSiteQueryResult.setTotal(siteList.size());
		return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteQueryResult);
	}
}

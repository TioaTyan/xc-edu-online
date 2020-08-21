package dev.tioachan.manage_cms.service;

import dev.tioachan.framework.domain.cms.CmsConfig;
import dev.tioachan.framework.model.response.QueryResponseResult;

import java.util.List;

public interface CmsConfigService {
	CmsConfig getConfigById(String id);

	QueryResponseResult findAll();

}

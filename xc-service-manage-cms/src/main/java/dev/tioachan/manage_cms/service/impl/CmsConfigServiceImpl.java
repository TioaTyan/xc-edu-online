package dev.tioachan.manage_cms.service.impl;

import dev.tioachan.framework.domain.cms.CmsConfig;
import dev.tioachan.framework.domain.cms.CmsSite;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.manage_cms.dao.CmsConfigRepository;
import dev.tioachan.manage_cms.service.CmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CmsConfigServiceImpl implements CmsConfigService {
    final
    CmsConfigRepository cmsConfigRepository;

    public CmsConfigServiceImpl(CmsConfigRepository cmsConfigRepository) {
        this.cmsConfigRepository = cmsConfigRepository;
    }

    //根据id查询配置管理信息
    public CmsConfig getConfigById(String id){
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        if(optional.isPresent()){
            CmsConfig cmsConfig = optional.get();
            return cmsConfig;
        }
        return null;
    }

    @Override
    public QueryResponseResult findAll() {
        List<CmsConfig> all = cmsConfigRepository.findAll();
        QueryResult<CmsConfig> cmsSiteQueryResult=new QueryResult<>();
        cmsSiteQueryResult.setList(all);
        cmsSiteQueryResult.setTotal(all.size());
        return new QueryResponseResult(CommonCode.SUCCESS, cmsSiteQueryResult);
    }
}
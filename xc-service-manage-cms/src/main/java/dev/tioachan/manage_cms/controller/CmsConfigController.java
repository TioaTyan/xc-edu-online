package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.cms.CmsConfigControllerApi;
import dev.tioachan.framework.domain.cms.CmsConfig;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.manage_cms.service.CmsConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cms/config")
public class CmsConfigController implements CmsConfigControllerApi {
    final
    CmsConfigService cmsConfigService;

    public CmsConfigController(CmsConfigService cmsConfigService) {
        this.cmsConfigService = cmsConfigService;
    }

    /**
     * 根据cms_config中的id获取CmsConfig信息
     * @param id    
     * @return CmsConfig
     */
    @Override
    @GetMapping("/getmodel/{id}")
    public CmsConfig getmodel(@PathVariable("id") String id) {
        return cmsConfigService.getConfigById(id);
    }

    @Override
    @GetMapping("/list")
    public QueryResponseResult findAll() {
        return cmsConfigService.findAll();
    }
}
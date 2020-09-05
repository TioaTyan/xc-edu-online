package dev.tioachan.manage_course.client;

import dev.tioachan.framework.client.XcServiceList;
import dev.tioachan.framework.domain.cms.CmsPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = XcServiceList.XC_SERVICE_MANAGE_CMS)
public interface CmsPageClient {
	//远程调用
	@GetMapping("/cms/page/get/{id}")
	public CmsPage findById(@PathVariable("id") String id);
}

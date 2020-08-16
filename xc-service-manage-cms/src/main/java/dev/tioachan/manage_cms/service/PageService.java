package dev.tioachan.manage_cms.service;

import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class PageService {

	@Autowired
	CmsPageRepository cmsPageRepository;

	/**
	 * 页面列表分页查询
	 *
	 * @param page             当前页码
	 * @param size             页面显示个数
	 * @param queryPageRequest 查询条件
	 * @return 页面列表
	 */
	public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
		if (queryPageRequest == null) {
			queryPageRequest = new QueryPageRequest();
		}

		//条件值
		CmsPage cmsPage = new CmsPage();
		//站点ID
		if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
			cmsPage.setSiteId(queryPageRequest.getSiteId());
		}
		//模板ID
		if (StringUtils.isNotEmpty(queryPageRequest.getTemplateId())) {
			cmsPage.setTemplateId(queryPageRequest.getTemplateId());
		}
		//页面别名（模糊查询）
		if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
			cmsPage.setPageAliase(queryPageRequest.getPageAliase());
		}

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

		Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);


		if (page <= 0) {
			page = 1;
		}
		page = page - 1;//为了适应mongodb的接口将页码减1
		if (size <= 0) {
			size = 20;
		}

		//分页对象
		Pageable pageable = PageRequest.of(page, size);
		Page<CmsPage> all =null;
		//分页查询
		//如果siteId为0则为全处查询，不使用条件
		if("findAll".equals(queryPageRequest.getSiteId())){
			all = cmsPageRepository.findAll(pageable);
		}else {
			all = cmsPageRepository.findAll(example,pageable);
		}

		QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<CmsPage>();
		cmsPageQueryResult.setList(all.getContent());
		cmsPageQueryResult.setTotal(all.getTotalElements());
		//返回结果
		return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
	}
}

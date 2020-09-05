package dev.tioachan.manage_cms.service.impl;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.framework.domain.cms.CmsTemplate;
import dev.tioachan.framework.domain.cms.request.QueryPageRequest;
import dev.tioachan.framework.domain.cms.response.CmsCode;
import dev.tioachan.framework.exception.ExceptionCast;
import dev.tioachan.framework.model.response.CommonCode;
import dev.tioachan.framework.model.response.QueryResponseResult;
import dev.tioachan.framework.model.response.QueryResult;
import dev.tioachan.framework.model.response.ResponseResult;
import dev.tioachan.manage_cms.dao.CmsPageRepository;
import dev.tioachan.manage_cms.dao.CmsTemplateRepository;
import dev.tioachan.manage_cms.service.PageService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {

	final
	CmsPageRepository cmsPageRepository;

	final
	CmsTemplateRepository cmsTemplateRepository;

	final
	RestTemplate restTemplate;

	final
	GridFsTemplate gridFsTemplate;

	final
	GridFSBucket gridFSBucket;

	public PageServiceImpl(
			CmsPageRepository cmsPageRepository,
			CmsTemplateRepository cmsTemplateRepository,
			RestTemplate restTemplate,
			GridFsTemplate gridFsTemplate, GridFSBucket gridFSBucket) {
		this.cmsPageRepository = cmsPageRepository;
		this.cmsTemplateRepository = cmsTemplateRepository;
		this.restTemplate = restTemplate;
		this.gridFsTemplate = gridFsTemplate;
		this.gridFSBucket = gridFSBucket;
	}



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
		Page<CmsPage> all;
		//分页查询
		//如果siteId为0则为全处查询，不使用条件
		if("findAll".equals(queryPageRequest.getSiteId())){
			all = cmsPageRepository.findAll(pageable);
		}else {
			all = cmsPageRepository.findAll(example,pageable);
		}

		QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<>();
		cmsPageQueryResult.setList(all.getContent());
		cmsPageQueryResult.setTotal(all.getTotalElements());
		//返回结果
		return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
	}

	@Override
	public ResponseResult addPage(CmsPage cmsPage) {
		if (StringUtils.isEmpty(cmsPage.getSiteId())||StringUtils.isEmpty(cmsPage.getTemplateId())){
			ExceptionCast.cast(CommonCode.INVALID_PARAM);
		}
		cmsPageRepository.save(cmsPage);
		return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult delPage(String pageId) {
		CmsPage page = getPage(pageId);
		if (page==null) {
			ExceptionCast.cast(CommonCode.INVALID_PARAM);
		}
		cmsPageRepository.delete(page);
		return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult updatePage(CmsPage cmsPage) {
		CmsPage page = getPage(cmsPage.getPageId());
		if (page==null){
			ExceptionCast.cast(CommonCode.INVALID_PARAM);
		}
		cmsPageRepository.save(cmsPage);
		return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public CmsPage getPage(String pageId) {
		Optional<CmsPage> page = cmsPageRepository.findById(pageId);
		if (page.isPresent()) {
			return page.get();
		}
		return null;
	}

	@Override
	public String getPageHtml(String pageId) {
		//获取页面模型数据
		Map model = getModelByPageId(pageId);
		if (model == null) {
			ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAISNULL);
		}

		//获取页面模板
		String templateContent = getTemplateByPageId(pageId);
		if (StringUtils.isEmpty(templateContent)) {
			ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
		}

		//执行静态化
		String html = generateHtml(templateContent, model);
		if (StringUtils.isEmpty(html)) {
			ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_HTMLISNULL);
		}

		return html;
	}


	//页面静态化
	public String generateHtml(String template, Map model) {
		try {
			//生成配置类
			Configuration configuration = new Configuration(Configuration.getVersion());
			//模板加载器
			StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
			stringTemplateLoader.putTemplate("template", template);
			//配置模板加载器
			configuration.setTemplateLoader(stringTemplateLoader);
			//获取模板
			Template template1 = configuration.getTemplate("template");
			return FreeMarkerTemplateUtils.processTemplateIntoString(template1, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//获取页面模型数据
	public Map getModelByPageId(String pageId) {
		//查询页面信息
		CmsPage cmsPage = getPage(pageId);
		if (cmsPage == null) {
			ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
		}
		//取出dataUrl
		//	http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f
		String dataUrl = cmsPage.getDataUrl();
		if (StringUtils.isEmpty(dataUrl)) {
			ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAURLISNULL);
		}
		ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
		return forEntity.getBody();
	}

	//获取页面模板
	public String getTemplateByPageId(String pageId) {
		//查询页面信息
		CmsPage cmsPage = getPage(pageId);
		if (cmsPage == null) {
			//页面不存在
			ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
		}

		//页面模板
		String templateId = cmsPage.getTemplateId();
		if (StringUtils.isEmpty(templateId)) {
			//页面模板id为空
			ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
		}
		//页面模板
		Optional<CmsTemplate> optional = cmsTemplateRepository.findById(templateId);
		if (!optional.isPresent()) {
			ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
		}

		CmsTemplate cmsTemplate = optional.get();

		//模板文件id
		String templateFileId = cmsTemplate.getTemplateFileId();
		//取出模板文件内容
		GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(templateFileId)));
		//打开下载流对象
		GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
		//创建GridFsResource
		GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
		try {
			return IOUtils.toString(gridFsResource.getInputStream(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}

package dev.tioachan.manage_cms.dao;


import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoDBTest {
	@Autowired
	CmsPageRepository cmsPageRepository;

	@Test
	public void Test01(){
//		List<CmsPage> bySiteId = cmsPageRepository.findBySiteId("5a751fab6abb5044e0d19ea1");
//		System.out.println(bySiteId);
	}

	@Test
	public void Test02() {

		//条件值对象
		CmsPage cmsPage = new CmsPage();
		cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");

		//条件匹配器
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("siteId", ExampleMatcher.GenericPropertyMatchers.exact());
		//创建条件实例
		Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);

		PageRequest pageable = PageRequest.of(0, 20);

		Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
//		Page<CmsPage> all = cmsPageRepository.findAll(pageable);
//		List<CmsPage> all = cmsPageRepository.findAll(example);
		List<CmsPage> content = all.getContent();
		System.out.println(all);
	}

	@Test
	public void Test03(){
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("sideId", ExampleMatcher.GenericPropertyMatchers.exact());

		CmsPage cmsPage = new CmsPage();
		cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");

		Example<CmsPage> example = Example.of(cmsPage, matcher);

		List<CmsPage> all = cmsPageRepository.findAll(example);

		System.out.println(all);

	}

	@Test
	public void Test04(){
		Pageable pageable = PageRequest.of(1, 20);
		//分页查询
		Page<CmsPage> all = cmsPageRepository.findAll(pageable);

		List<CmsPage> content = all.getContent();

		System.out.println(content);
	}

	@Test
	public void Test05(){
		//条件匹配器
		//页面名称模糊查询，需要自定义字符串的匹配器实现模糊查询
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
		//条件值
		CmsPage cmsPage = new CmsPage();
		cmsPage.setPageAliase("课程详情页面");
		//创建条件实例
		Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
		//页码
		//分页对象
		Pageable pageable =  PageRequest.of(0, 10);
		//分页查询
//		Page<CmsPage> all = cmsPageRepository.findAll(example,pageable);
//		List<CmsPage> content = all.getContent();
		List<CmsPage> all = cmsPageRepository.findAll(example);
		System.out.println(all);
	}

	//正常代码
	@Test
	public void Test06(){

		//分页参数
		int page = 0;//从0开始
		int size = 10;
		Pageable pageable = PageRequest.of(page,size);

		//条件值对象
		CmsPage cmsPage= new CmsPage();
		//要查询5a751fab6abb5044e0d19ea1站点的页面
//        cmsPage.setSiteId("5b30b052f58b4411fc6cb1cf");
		//设置模板id条件
//        cmsPage.setTemplateId("5ad9a24d68db5239b8fef199");
		//设置页面别名
		cmsPage.setPageAliase("轮播");
		//条件匹配器
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
//        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
		//ExampleMatcher.GenericPropertyMatchers.contains() 包含关键字
//        ExampleMatcher.GenericPropertyMatchers.startsWith()//前缀匹配
		//定义Example
		Example<CmsPage> example = Example.of(cmsPage,exampleMatcher);
		Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
		List<CmsPage> content = all.getContent();
		System.out.println(content);
	}
}

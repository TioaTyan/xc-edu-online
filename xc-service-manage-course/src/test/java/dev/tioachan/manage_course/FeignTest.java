package dev.tioachan.manage_course;

import dev.tioachan.framework.domain.cms.CmsPage;
import dev.tioachan.manage_course.client.CmsPageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FeignTest {
	@Autowired
	CmsPageClient cmsPageClient;

	@Test
	void contextLoads() {
	}

	@Test
	public void Test01(){
		CmsPage cmsPage = cmsPageClient.findById("5a754adf6abb500ad05688d9");
		System.out.println(cmsPage);
	}
}

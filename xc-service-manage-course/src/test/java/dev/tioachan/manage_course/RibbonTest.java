package dev.tioachan.manage_course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
public class RibbonTest {

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void Test01(){
		String serverId="XS-SERVICE-MANAGE-CMS";
		ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://" + serverId + "/cms/page/get/", Map.class);
		Map body = forEntity.getBody();
		System.out.println(body);
	}
}

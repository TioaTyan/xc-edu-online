package dev.tioachan.fastdfsdemo;

import com.github.tobato.fastdfs.domain.fdfs.StorageNode;
import com.github.tobato.fastdfs.service.TrackerClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FastdfsDemoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private TrackerClient trackerClient;

	@Test
	public void testGetStoreStorage() {
		StorageNode client = trackerClient.getStoreStorage();
		System.out.println(client);
	}
}

package dev.tioachan.fastdfsdemo;

import com.github.tobato.fastdfs.domain.fdfs.GroupState;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorageNode;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.domain.upload.FastImageFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import com.mysql.cj.util.TestUtils;
import dev.tioachan.fastdfsdemo.utils.FastDFSClient;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

@SpringBootTest
class FastdfsDemoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private TrackerClient trackerClient;

	@Autowired
	protected FastFileStorageClient storageClient;

	@Autowired
	private FastDFSClient fastDFSClient;

	@Test
	public void testGetStoreStorage() {
		StorageNode client = trackerClient.getStoreStorage();
		System.out.println(client);
	}

	@Test
	public void testListGroups() {
		List<GroupState> list = trackerClient.listGroups();
		for (GroupState groupState : list) {
			System.out.println(groupState);
		}
	}
	@Test
	public void uploadTest() throws IOException {
		String file = fastDFSClient.uploadFile(new File("/Users/tioachan/Pictures/Wallpaper/FF/HayCxDK.jpg"));
		System.out.println(file);
	}
}

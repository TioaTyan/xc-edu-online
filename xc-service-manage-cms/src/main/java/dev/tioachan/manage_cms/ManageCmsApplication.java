package dev.tioachan.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("dev.tioachan.framework.domain.cms")
@ComponentScan(basePackages = {"dev.tioachan.api"})
@ComponentScan(basePackages = {"dev.tioachan.manage_cms","dev.tioachan.framework"})
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ManageCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCmsApplication.class, args);
	}

}

package dev.tioachan.manage_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("dev.tioachan.framework.domain.course")//扫描实体类
@ComponentScan(basePackages={"dev.tioachan.api"})//扫描接口
@ComponentScan(basePackages={"dev.tioachan.manage_course"})
@ComponentScan(basePackages={"dev.tioachan.framework"})//扫描common下的所有类
@EnableEurekaClient
public class XcServiceManageCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcServiceManageCourseApplication.class, args);
	}

}

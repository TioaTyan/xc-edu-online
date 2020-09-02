package dev.tioachan.filesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//扫描所在包及子包的bean，注入到ioc中
@EntityScan("dev.tioachan.framework.domain.filesystem")//扫描实体类
@ComponentScan(basePackages={"dev.tioachan.api"})//扫描接口
@ComponentScan(basePackages={"dev.tioachan.framework"})//扫描common下的所有类
@ComponentScan(basePackages={"dev.tioachan.filesystem"})//扫描本项目下的所有类
public class XcFileSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(XcFileSystemApplication.class);
	}
}

package dev.tioachan.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@EntityScan("dev.tioachan.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages = {"dev.tioachan.api"})//扫描接口
@ComponentScan(basePackages = {"dev.tioachan.manage_cms"})//扫描本项目下的所有类
@ComponentScan(basePackages = {"dev.tioachan.framework"})//扫描common包下的类
public class ManageCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCmsApplication.class, args);
	}

}

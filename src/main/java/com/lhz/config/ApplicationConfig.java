package com.lhz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
//@PropertySource("classpath:application-test.properties")
@ConfigurationProperties(prefix="spring.application")
public class ApplicationConfig {
	      
	//文件上传路径
	private  String  profiles;

	public  String getProfiles() {
		return profiles;
	}

	public  void setProfiles(String profiles) {
		this.profiles = profiles;
	}

	
	@Override
	public String toString() {
		System.out.println(profiles);
		return super.toString();
	}
}

package com.lhz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {



// 访问图片方法
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {

	/**
     * @Description: 对文件的路径进行配置, 创建一个虚拟路径/Path/** ，即只要在< img src="/Path/picName.jpg" />便可以直接引用图片
     *这是图片的物理路径  "file:/+本地图片的地址"
     */
  /*  registry.addResourceHandler("/images/**").addResourceLocations("file:/C:/upload/");
    super.addResourceHandlers(registry);*/
}
}
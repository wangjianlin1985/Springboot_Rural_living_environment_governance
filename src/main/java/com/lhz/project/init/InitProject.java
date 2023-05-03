package com.lhz.project.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by shirukai on 2018/7/12
 */
@Component
public class InitProject implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(InitProject.class);

    @Autowired
    InitDictData initDictData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("==========启动项目，初始化数据字典===========");
        initDictData.queryDic();

    }
}
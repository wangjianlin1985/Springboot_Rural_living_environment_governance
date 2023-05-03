package com.lhz.project.init;

import com.lhz.project.entity.SysDictData;
import com.lhz.project.mapper.SysDictDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;


@Component
public class InitDictData {
    private static final Logger LOG = LoggerFactory.getLogger(InitDictData.class);
    @Autowired
    SysDictDataMapper sysDictDataMapper;

    private static HashMap<String, Object> hashMap = new HashMap<>();

    /**
     * 从数据库中取值放入到HashMap中(存储字典)
     */

    public  void queryDic() {
        LOG.info("==========初始化数据字典===========");
        SysDictData sdd = new SysDictData();
        sdd.setPid(0);
        List<SysDictData> dics = sysDictDataMapper.findList(sdd);

        for (int i = 0; i < dics.size(); i++) {
            SysDictData dic = dics.get(i);
            LOG.info(dic.toString());
            SysDictData sdChild = new SysDictData();
            sdChild.setPid(dic.getId());
            List<SysDictData> list = sysDictDataMapper.findList(sdChild);
            hashMap.put(dic.getDataType(), list);
        }
    }

    /**
     * 根据类型获取数据字典
     * @param type
     * @return
     */
    public static List<SysDictData> getDictByType(String type) {
        List<SysDictData> value = (List<SysDictData>) hashMap.get(type);
        return value;
    }
}
package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysSerialNumber;

public interface SysSerialNumberMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysSerialNumber record);

    SysSerialNumber selectByPrimaryKey(Integer id);

    /**
     * 根据编号类型和中间编号查询最大值
     * @param record
     * @return
     */
    int getNumber(SysSerialNumber record);

    List<SysSerialNumber> findList(SysSerialNumber record);
    
    int updateByPrimaryKeySelective(SysSerialNumber record);


}
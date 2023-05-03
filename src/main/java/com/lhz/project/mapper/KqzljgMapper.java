package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.Kqzljg;

public interface KqzljgMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(Kqzljg record);

    Kqzljg selectByPrimaryKey(Integer id);


    
    List<Kqzljg> tongjiDate();
       List<Kqzljg> tongjiPm();
    
    List<Kqzljg> findList(Kqzljg record);
    
    int updateByPrimaryKeySelective(Kqzljg record);


}
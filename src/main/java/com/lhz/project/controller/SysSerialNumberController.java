package com.lhz.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lhz.project.service.SysSerialNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhz.project.entity.SysSerialNumber;
import com.lhz.project.mapper.SysSerialNumberMapper;



@Controller
@RequestMapping ( "/SysSerialNumber" )
public class SysSerialNumberController{

    @Autowired
    SysSerialNumberService sysSerialNumberService;


    /**
     * 根据项目类型获取编号
     * @param obj
     * @return
     */
    @ResponseBody
    @RequestMapping(value= "/getSerialNo")
    public String getSerialNo(SysSerialNumber obj) {
    	String list = sysSerialNumberService.getSerialNo(obj);
        return list;
    }
    

    


}

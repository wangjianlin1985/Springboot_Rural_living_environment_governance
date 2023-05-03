package com.lhz.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhz.project.entity.SysRoleMenu;
import com.lhz.project.mapper.SysRoleMenuMapper;



@Controller
@RequestMapping ( "/SysRoleMenu" )
public class SysRoleMenuController{

    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;



    
    @ResponseBody
    @RequestMapping(value= "/insertSysRoleMenu")
    public Map<String,Object> addSysRoleMenu(SysRoleMenu obj) {
        Map<String,Object> returnMap = new HashMap<String,Object>();


        List<SysRoleMenu> smList = sysRoleMenuMapper.findList(obj);
        if(smList.size()>0){
            int  del = sysRoleMenuMapper.deleteByRoleId(obj.getRoleId());
        }
        String[] menuIds = obj.getMenuIds().split(",");
        for(int i=0;i<menuIds.length;i++){
            SysRoleMenu sm = new SysRoleMenu();
            sm.setMenuId(Integer.parseInt(menuIds[i]));
            sm.setRoleId(obj.getRoleId());
            int t =sysRoleMenuMapper.insertSelective(sm);
        }
        returnMap.put("showInfo", "绑定成功！");


        return returnMap;
    }
    

    
    

}

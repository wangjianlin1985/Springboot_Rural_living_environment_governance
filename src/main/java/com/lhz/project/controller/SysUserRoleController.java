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
import com.lhz.project.entity.SysUserRole;
import com.lhz.project.mapper.SysUserRoleMapper;



@Controller
@RequestMapping ( "/SysUserRole" )
public class SysUserRoleController{

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

	
    @RequestMapping(value="SysUserRoleHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("sysUserRole");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(SysUserRole obj) {
    	List list = sysUserRoleMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findSysUserRolePage( int currentPage,int rows,  SysUserRole obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<SysUserRole> list = sysUserRoleMapper.findList(obj);
    	PageInfo<SysUserRole> pageInfo = new PageInfo<SysUserRole>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertSysUserRole")
    public Map<String,Object> addSysUserRole(SysUserRole obj) {
    	Map<String,Object> returnMap = new HashMap<String,Object>();
    	
    	SysUserRole userRole = new SysUserRole();
    	userRole.setUserId(obj.getUserId());
    	List<SysUserRole> list=	sysUserRoleMapper.findList(userRole);
    	if(list!=null && list.size()>0) {
    		obj.setId(list.get(0).getId());
    		int i =sysUserRoleMapper.updateByPrimaryKeySelective(obj);
            if (i == 0)
            	returnMap.put("showInfo", "修改失败！");
            else
            	returnMap.put("showInfo", "修改成功！");
    		
    	}else {
    		int i =sysUserRoleMapper.insertSelective(obj);
            if (i == 0)
            	returnMap.put("showInfo", "添加失败！");
            else
            	returnMap.put("showInfo", "添加成功！");
    	}
    
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSysUserRole")
    public Map<String,Object> updateSysUserRole(SysUserRole obj) {
    	int i =sysUserRoleMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSysUserRole")
    public Map<String,Object> deleteSysUserRole(int id) {
    	int i =sysUserRoleMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

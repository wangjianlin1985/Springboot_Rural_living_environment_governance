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
import com.lhz.project.entity.SysRole;
import com.lhz.project.mapper.SysRoleMapper;



@Controller
@RequestMapping ( "/SysRole" )
public class SysRoleController{

    @Autowired
    SysRoleMapper sysRoleMapper;

	
    @RequestMapping(value="SysRoleHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("sysrole");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(SysRole obj) {
    	List list = sysRoleMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findSysRolePage( int currentPage,int rows,  SysRole obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<SysRole> list = sysRoleMapper.findList(obj);
    	PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertSysRole")
    public Map<String,Object> addSysRole(SysRole obj) {
    	int i =sysRoleMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSysRole")
    public Map<String,Object> updateSysRole(SysRole obj) {
    	int i =sysRoleMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSysRole")
    public Map<String,Object> deleteSysRole(int id) {
    	int i =sysRoleMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

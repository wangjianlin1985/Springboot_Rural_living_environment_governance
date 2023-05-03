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
import com.lhz.project.entity.SysUser;
import com.lhz.project.mapper.SysUserMapper;



@Controller
@RequestMapping ( "/SysUser" )
public class SysUserController{

    @Autowired
    SysUserMapper sysUserMapper;

	
    @RequestMapping(value="SysUserHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("sysUser");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(SysUser obj) {
    	List list = sysUserMapper.findList(obj);
        return list;
    }

    @ResponseBody
    @RequestMapping(value= "/get")
    public SysUser findList(int id) {
        SysUser list = sysUserMapper.selectByPrimaryKey(id);
        return list;
    }

    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findSysUserPage( int currentPage,int rows,  SysUser obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<SysUser> list = sysUserMapper.findList(obj);
    	PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertSysUser")
    public Map<String,Object> addSysUser(SysUser obj) {
    	
    	//设置人员编号，用于登录
    	obj.setUserNo(String.valueOf(Integer.parseInt(sysUserMapper.getMaxUserNo().getUserNo())+1));
    	int i =sysUserMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSysUser")
    public Map<String,Object> updateSysUser(SysUser obj) {
    	int i =sysUserMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSysUser")
    public Map<String,Object> deleteSysUser(int id) {
    	int i =sysUserMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

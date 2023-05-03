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
import com.lhz.project.entity.SysDepartment;
import com.lhz.project.mapper.SysDepartmentMapper;



@Controller
@RequestMapping ( "/SysDepartment" )
public class SysDepartmentController{

    @Autowired
    SysDepartmentMapper sysDepartmentMapper;

	
    @RequestMapping(value="SysDepartmentHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("sysdepartment");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List<SysDepartment> findList(SysDepartment obj) {
    	List<SysDepartment> list = sysDepartmentMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findSysDepartmentPage( int currentPage,int rows,  SysDepartment obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<SysDepartment> list = sysDepartmentMapper.findList(obj);
    	PageInfo<SysDepartment> pageInfo = new PageInfo<SysDepartment>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertSysDepartment")
    public Map<String,Object> addSysDepartment(SysDepartment obj) {
    	int i =sysDepartmentMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSysDepartment")
    public Map<String,Object> updateSysDepartment(SysDepartment obj) {
    	int i =sysDepartmentMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSysDepartment")
    public Map<String,Object> deleteSysDepartment(int id) {
    	int i =sysDepartmentMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

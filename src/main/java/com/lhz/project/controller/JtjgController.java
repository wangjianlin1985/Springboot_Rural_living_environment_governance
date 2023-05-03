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
import com.lhz.project.entity.Jtjg;
import com.lhz.project.mapper.JtjgMapper;



@Controller
@RequestMapping ( "/Jtjg" )
public class JtjgController{

    @Autowired
    JtjgMapper jtjgMapper;

	
    @RequestMapping(value="JtjgHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("jtjg");
   		return mv;
   	}
    
    @ResponseBody 
    @RequestMapping(value= "/tongji")
    List<Map<String,Object>> tongjiwushui(){
    	
    	return jtjgMapper.tongji();
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(Jtjg obj) {
    	List list = jtjgMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findJtjgPage( int currentPage,int rows,  Jtjg obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<Jtjg> list = jtjgMapper.findList(obj);
    	PageInfo<Jtjg> pageInfo = new PageInfo<Jtjg>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertJtjg")
    public Map<String,Object> addJtjg(Jtjg obj) {
    	int i =jtjgMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateJtjg")
    public Map<String,Object> updateJtjg(Jtjg obj) {
    	int i =jtjgMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteJtjg")
    public Map<String,Object> deleteJtjg(int id) {
    	int i =jtjgMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

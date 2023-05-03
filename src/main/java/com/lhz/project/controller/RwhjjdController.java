package com.lhz.project.controller;

import java.util.ArrayList;
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
import com.lhz.project.entity.Rwhjjd;
import com.lhz.project.entity.Szjg;
import com.lhz.project.mapper.RwhjjdMapper;



@Controller
@RequestMapping ( "/Rwhjjd" )
public class RwhjjdController{

    @Autowired
    RwhjjdMapper rwhjjdMapper;

	
    @RequestMapping(value="RwhjjdHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("rwhjjd");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/tongji")
    public Map<String,Object> tongji() {
    	Rwhjjd list = rwhjjdMapper.tongji();
    	List<String> names = new ArrayList<>();
    	names.add("儿童");
    	names.add("青少年");
    	names.add("中年");
    	names.add("老年");

    	
    	List<String> values = new ArrayList<>();
    	values.add(list.getErtong());
    	values.add(list.getQingshaonian());
    	values.add(list.getZhongnian());
    	values.add(list.getLaonian());

    	
    	
    	
    	Map<String,Object> map = new HashMap<>();
    	map.put("names", names);
    	map.put("values", values);
        return map;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(Rwhjjd obj) {
    	List list = rwhjjdMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findRwhjjdPage( int currentPage,int rows,  Rwhjjd obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<Rwhjjd> list = rwhjjdMapper.findList(obj);
    	PageInfo<Rwhjjd> pageInfo = new PageInfo<Rwhjjd>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertRwhjjd")
    public Map<String,Object> addRwhjjd(Rwhjjd obj) {
    	int i =rwhjjdMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateRwhjjd")
    public Map<String,Object> updateRwhjjd(Rwhjjd obj) {
    	int i =rwhjjdMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteRwhjjd")
    public Map<String,Object> deleteRwhjjd(int id) {
    	int i =rwhjjdMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

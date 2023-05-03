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
import com.lhz.project.entity.Szjg;
import com.lhz.project.mapper.SzjgMapper;



@Controller
@RequestMapping ( "/Szjg" )
public class SzjgController{

    @Autowired
    SzjgMapper szjgMapper;

	
    @RequestMapping(value="SzjgHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("szjg");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(Szjg obj) {
    	List list = szjgMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/tongji")
    public Map<String,Object> tongji() {
    	Szjg list = szjgMapper.tongji();
    	List<String> names = new ArrayList<>();
    	names.add("自来水");
    	names.add("井水");
    	names.add("雨水");
    	names.add("湖泊水");
    	names.add("其他");
    	
    	List<String> values = new ArrayList<>();
    	values.add(list.getZiliashui());
    	values.add(list.getJinshui());
    	values.add(list.getYushui());
    	values.add(list.getHuposhui());
    	values.add(list.getQita());
    	
    	
    	
    	Map<String,Object> map = new HashMap<>();
    	map.put("names", names);
    	map.put("values", values);
        return map;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findSzjgPage( int currentPage,int rows,  Szjg obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<Szjg> list = szjgMapper.findList(obj);
    	PageInfo<Szjg> pageInfo = new PageInfo<Szjg>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertSzjg")
    public Map<String,Object> addSzjg(Szjg obj) {
    	int i =szjgMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSzjg")
    public Map<String,Object> updateSzjg(Szjg obj) {
    	int i =szjgMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSzjg")
    public Map<String,Object> deleteSzjg(int id) {
    	int i =szjgMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

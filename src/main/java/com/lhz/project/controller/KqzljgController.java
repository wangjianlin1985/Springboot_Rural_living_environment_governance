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
import com.lhz.project.entity.Kqzljg;
import com.lhz.project.entity.Szjg;
import com.lhz.project.mapper.KqzljgMapper;



@Controller
@RequestMapping ( "/Kqzljg" )
public class KqzljgController{

    @Autowired
    KqzljgMapper kqzljgMapper;

	
    @RequestMapping(value="KqzljgHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("kqzljg");
   		return mv;
   	}
    
    
    @ResponseBody
    @RequestMapping(value= "/tongji")
    public Map<String,Object> tongji() {
    	List<Kqzljg> dates = kqzljgMapper.tongjiDate();
    	List<String> names = new ArrayList<>();
    	for (Kqzljg string : dates) {
    		names.add(string.getCreateTime());
		}
    	
    	
    	List<Kqzljg> pms = kqzljgMapper.tongjiPm();
    	List<String> values = new ArrayList<>();
    	for (Kqzljg string : pms) {
    		values.add(string.getPm25());
		}
    	
    	
    	
    	Map<String,Object> map = new HashMap<>();
    	map.put("names", names);
    	map.put("values", values);
        return map;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(Kqzljg obj) {
    	List list = kqzljgMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findKqzljgPage( int currentPage,int rows,  Kqzljg obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<Kqzljg> list = kqzljgMapper.findList(obj);
    	PageInfo<Kqzljg> pageInfo = new PageInfo<Kqzljg>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertKqzljg")
    public Map<String,Object> addKqzljg(Kqzljg obj) {
    	int i =kqzljgMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateKqzljg")
    public Map<String,Object> updateKqzljg(Kqzljg obj) {
    	int i =kqzljgMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteKqzljg")
    public Map<String,Object> deleteKqzljg(int id) {
    	int i =kqzljgMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

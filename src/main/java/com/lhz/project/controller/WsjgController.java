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
import com.lhz.project.entity.Wsjg;
import com.lhz.project.mapper.WsjgMapper;



@Controller
@RequestMapping ( "/Wsjg" )
public class WsjgController{

    @Autowired
    WsjgMapper wsjgMapper;

	
    @RequestMapping(value="WsjgHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("wsjg");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(Wsjg obj) {
    	List list = wsjgMapper.findList(obj);
        return list;
    }
    
    
    
    
    
    @ResponseBody 
    @RequestMapping(value= "/tongjilaji")
    List<Map<String,Object>> tongjilaji(){
    	
    	return wsjgMapper.tongjilaji();
    }
    
    
    @ResponseBody 
    @RequestMapping(value= "/tongjiwushui")
    List<Map<String,Object>> tongjiwushui(){
    	
    	return wsjgMapper.tongjiwushui();
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findWsjgPage( int currentPage,int rows,  Wsjg obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<Wsjg> list = wsjgMapper.findList(obj);
    	PageInfo<Wsjg> pageInfo = new PageInfo<Wsjg>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertWsjg")
    public Map<String,Object> addWsjg(Wsjg obj) {
    	int i =wsjgMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateWsjg")
    public Map<String,Object> updateWsjg(Wsjg obj) {
    	int i =wsjgMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteWsjg")
    public Map<String,Object> deleteWsjg(int id) {
    	int i =wsjgMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

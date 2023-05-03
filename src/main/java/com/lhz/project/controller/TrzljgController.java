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
import com.lhz.project.entity.Trzljg;
import com.lhz.project.mapper.TrzljgMapper;



@Controller
@RequestMapping ( "/Trzljg" )
public class TrzljgController{

    @Autowired
    TrzljgMapper trzljgMapper;

	
    @RequestMapping(value="TrzljgHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("trzljg");
   		return mv;
   	}

    @ResponseBody 
    @RequestMapping(value= "/tongji")
    List<Map<String,Object>> tongji(){
    	
    	return trzljgMapper.tongji();
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(Trzljg obj) {
    	List list = trzljgMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findTrzljgPage( int currentPage,int rows,  Trzljg obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<Trzljg> list = trzljgMapper.findList(obj);
    	PageInfo<Trzljg> pageInfo = new PageInfo<Trzljg>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTrzljg")
    public Map<String,Object> addTrzljg(Trzljg obj) {
    	int i =trzljgMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTrzljg")
    public Map<String,Object> updateTrzljg(Trzljg obj) {
    	int i =trzljgMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTrzljg")
    public Map<String,Object> deleteTrzljg(int id) {
    	int i =trzljgMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}

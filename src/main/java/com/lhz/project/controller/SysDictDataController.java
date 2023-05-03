package com.lhz.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lhz.project.init.InitDictData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhz.project.entity.SysDictData;
import com.lhz.project.mapper.SysDictDataMapper;



@Controller
@RequestMapping ( "/SysDictData" )
public class SysDictDataController{

    @Autowired
    SysDictDataMapper sysDictDataMapper;
    @Autowired
    InitDictData initDictData;
	
    @RequestMapping(value="SysDictDataHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("sysdictdata");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(SysDictData obj) {
    	List list = sysDictDataMapper.findList(obj);
        return list;
    }

    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findSysDictDataPage( int currentPage,int rows,  SysDictData obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<SysDictData> list = sysDictDataMapper.findList(obj);
    	PageInfo<SysDictData> pageInfo = new PageInfo<SysDictData>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertSysDictData")
    public Map<String,Object> addSysDictData(SysDictData obj) {
    	int i =sysDictDataMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0) {
            returnMap.put("showInfo", "添加失败！");
        }else {
            initDictData.queryDic();//初始化数据字典
            returnMap.put("showInfo", "添加成功！");
        }
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSysDictData")
    public Map<String,Object> updateSysDictData(SysDictData obj) {
    	int i =sysDictDataMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0) {
            returnMap.put("showInfo", "修改失败！");
        }else {
            initDictData.queryDic();//初始化数据字典
            returnMap.put("showInfo", "修改成功！");
        }
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSysDictData")
    public Map<String,Object> deleteSysDictData(int id) {
    	int i =sysDictDataMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0) {
            returnMap.put("showInfo", "删除失败！");
        }else {
            initDictData.queryDic();//初始化数据字典
            returnMap.put("showInfo", "删除成功！");
        }
        return returnMap;
    }


    @ResponseBody
    @RequestMapping(value= "/getDictByType")
    public  List<SysDictData> getDictByType(String type) {
        return InitDictData.getDictByType(type);
    }

}

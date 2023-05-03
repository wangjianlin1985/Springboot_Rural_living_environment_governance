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
import com.lhz.project.entity.SysMenu;
import com.lhz.project.mapper.SysMenuMapper;



@Controller
@RequestMapping ( "/SysMenu" )
public class SysMenuController{

    @Autowired
    SysMenuMapper sysMenuMapper;

	
    @RequestMapping(value="SysMenuHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    ModelAndView mv = new ModelAndView("sysMenu");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(SysMenu obj) {
    	List list = sysMenuMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Map<String,Object> findSysMenuPage( int currentPage,int rows,  SysMenu obj) {

	 //使用分页插件,核心代码就这一行，页数、每页行数
    	PageHelper.startPage(currentPage, rows);
    	List<SysMenu> list = sysMenuMapper.findList(obj);
    	PageInfo<SysMenu> pageInfo = new PageInfo<SysMenu>(list);
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("total",pageInfo.getTotal());
		result.put("rows",pageInfo.getList());
        return result;


    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertSysMenu")
    public Map<String,Object> addSysMenu(SysMenu obj) {
    	int i =sysMenuMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSysMenu")
    public Map<String,Object> updateSysMenu(SysMenu obj) {
    	int i =sysMenuMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSysMenu")
    public Map<String,Object> deleteSysMenu(int id) {
    	int i =sysMenuMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    
    
    @ResponseBody
    @RequestMapping(value= "/getSysMenuTreeData")
    public Map<String,Object> getSysMenuTreeData() {
    	
 	   List<SysMenu> list2 = sysMenuMapper.findList(null);
    	
    	 Map<String,Object> map = new HashMap<String,Object>();
    	 map.put("data", this.buildMenuTree(list2,"0"));
    	// List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
    	//this.getTree("0",map);
    	
        return map;
    }

    /**
     * 根据登录用户的角色获取菜单，只获取绑定的菜单
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value= "/getMenusByUserByRoleId")
    public Map<String,Object> getMenusByUserByRoleId(String roleId) {
        List<SysMenu> list2 = sysMenuMapper.getMenusByUserByRoleId(roleId);
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> list =  this.builMainPageMenuTree(list2,"1");
        Map<String,Object> node = new HashMap<String,Object>();

        node.put("id","000");
        node.put("text","首页");
        node.put("icon","fa fa-home fa-lg");
        node.put("url","/TLogin/home");
        list.add(0,node);
        map.put("data", list);

        // List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        //this.getTree("0",map);
        return map;
    }

    /**
     * 获取菜单，若菜单已经被角色绑定，则添加状态
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value= "/getSysMenuTreeDataByRoleId")
    public Map<String,Object> getSysMenuTreeDataByRoleId(String roleId) {

        List<SysMenu> list2 = sysMenuMapper.getMenusByRoleId(roleId);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data", this.buildMenuTree(list2,"1"));
        // List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        //this.getTree("0",map);

        return map;
    }
    /**
     * 构建菜单树
     *
     * @param menuList
     * @param pid
     * @return
     */
    private List<Map<String,Object>> buildMenuTree(List<SysMenu> menuList, String pid) {
    	 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        menuList.forEach(menu -> {
            if (pid.equals(menu.getPid())) {
            	  Map<String,Object> node = new HashMap<String,Object>();
       		   node.put("id", menu.getId());
       		   node.put("text", menu.getMenuName());
       		   node.put("href", menu.getUrl());
       		   node.put("url", menu.getUrl());//用户登录查看菜单的前端插件需要传url
       		   node.put("icon", menu.getIcon());
				node.put("pid", menu.getPid());
       		   String[] arr = new String[] {menu.getType()};
       		   node.put("tags", arr);
       		   Map<String,Object> map2 = new HashMap<String,Object>();
       		 /*  map2.put("expanded", true);*/
       		   if(menu.getType().equals("按钮")) {
       			 map2.put("disabled", true);
       			 node.put("backColor","#1606ec");
       		   }
       		   if(menu.getRoleMenuId()!=null && !"".equals(menu.getRoleMenuId())){
                   map2.put("checked", true);
               }
       		   node.put("state", map2);
       		   node.put("nodes", buildMenuTree(menuList, menu.getId()+""));
            //	menu.setChildMenus(buildMenuTree(menuList, menu.getId()+""));
       			list.add(node);
            }
        });
        return list;
    }

    /**
     * 构建登录成功菜单树
     *
     * @param menuList
     * @param pid
     * @return
     */
    private List<Map<String,Object>> builMainPageMenuTree(List<SysMenu> menuList, String pid) {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        menuList.forEach(menu -> {
            if (pid.equals(menu.getPid())) {
                Map<String,Object> node = new HashMap<String,Object>();
                node.put("id", menu.getId());
                node.put("text", menu.getMenuName());
                node.put("url", menu.getUrl());//用户登录查看菜单的前端插件需要传url
                node.put("icon", menu.getIcon());
                node.put("menus", buildMenuTree(menuList, menu.getId()+""));
                //	menu.setChildMenus(buildMenuTree(menuList, menu.getId()+""));
                list.add(node);
            }
        });
        return list;
    }
}

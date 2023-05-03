package com.lhz.project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.lhz.project.entity.SysUser;

import com.lhz.project.mapper.SysUserMapper;



@Controller
@RequestMapping ( "/TLogin" )
public class IndexController{
  

    @Autowired
    SysUserMapper tUserMapper;

    
    @ResponseBody
    @RequestMapping(value="/login")
	public Map<String, Object>   adminLogin(SysUser tuser,HttpSession session,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String,Object>();


		if(tuser.getVerificationCode()!=null && !"".equals(tuser.getVerificationCode())) {
			String code = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY); 
			if(code.equals(tuser.getVerificationCode())) {
				SysUser tAdmin  = tUserMapper.login(tuser);
				if(tAdmin!=null) {
					if(tAdmin.getPassword().equals(tuser.getPassword())) {
						session.setAttribute("user", tAdmin);
						map.put("isFlag", 0);
					}else {
						map.put("isFlag", 1);
					}
				}else {
					map.put("isFlag", 2);
				}
			}else {
				map.put("isFlag", 3);
			}
		}
		return map;
	}
    

    @RequestMapping(value="/statis")
   	public String statis(HttpSession session,HttpServletRequest request){
   		return "statis";
   	}
    
    @RequestMapping(value="/home")
   	public String getHome(HttpSession session,HttpServletRequest request){
   		return "home";
   	}
    
    @RequestMapping(value="/index")
   	public String getIndex(HttpSession session,HttpServletRequest request){
   		return "login";
   	}
    @RequestMapping(value="/main")
   	public String getMainPage(HttpSession session,HttpServletRequest request){
   		return "main";
   	}
    
    
    
    @RequestMapping(value="/loginout")
   	public String loginout(HttpSession session,HttpServletRequest request){
    	session.removeAttribute("user");
   		return "login";
   	}
    
    
    
    @ResponseBody
    @RequestMapping(value= "/editPassword")
    public Map<String,Object> updateTLogin(SysUser obj) {
    	int i =tUserMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！请重新登录");
        return returnMap;
    }
    
    
    


}

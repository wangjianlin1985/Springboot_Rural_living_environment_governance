package com.lhz.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        HttpSession session=request.getSession();
        Object ob=session.getAttribute("user");
        if (ob!=null) {
            return true;
        }
        session.setAttribute("preurl",request.getRequestURI());
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        response.sendRedirect(tempContextUrl+"TLogin/index");
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler,ModelAndView model) throws Exception{
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                            Object handler,Exception ex) throws Exception{
    }
}

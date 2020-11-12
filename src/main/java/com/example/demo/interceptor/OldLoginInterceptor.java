package com.example.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OldLoginInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("\n-- OldLoginInterceptor.preHandle ---");
        logger.info("Request url: "+request.getRequestURL());
        logger.info("Sorry, this url is no longer used, Redirect to admin/login");
        response.sendRedirect(request.getContextPath()+"/admin/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //This code under will be not run because preHandle is return false;
        logger.info("\n--OldLoginInterceptor.postHandle---");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //This code under will be not run because preHandle is return false;
        logger.info("\n--OldLoginInterceptor.afterCompletion---");
    }
}

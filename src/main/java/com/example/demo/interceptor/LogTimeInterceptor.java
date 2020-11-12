package com.example.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogTimeInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        logger.info("\n- LogInterception.preHandle ---");
        logger.info("Request url: "+ request.getRequestURL());
        logger.info("Start time: "+ System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("\n--LogInterceptor.postHandle---");
        logger.info("Request url: "+request.getRequestURL());
        // right here you can add some attributes into the ModelAndView
        // and use them in views (jsp,..)
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("\n---LogInterceptor.afterCompletion--");
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        logger.info("Request url: "+request.getRequestURL());
        logger.info("End time: "+endTime);
        logger.info("Total time: "+(endTime - startTime));
    }
}

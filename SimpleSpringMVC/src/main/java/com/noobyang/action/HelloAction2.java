package com.noobyang.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction2 implements Controller {

    private static final Logger log = LoggerFactory.getLogger(HelloAction2.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        log.info("handleRequest");
        // 跳转到hello.jsp页面
        modelAndView.setViewName("hello");

        return modelAndView;
    }
}

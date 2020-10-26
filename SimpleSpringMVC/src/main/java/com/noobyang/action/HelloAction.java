package com.noobyang.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloAction implements Controller {

    private static final Logger log = LoggerFactory.getLogger(HelloAction.class);

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        log.info("handleRequest");
        // 跳转到hello.jsp页面
        modelAndView.setViewName("hello");

        return modelAndView;
    }
}

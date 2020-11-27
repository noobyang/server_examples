package com.noobyang.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManyOneAction implements Controller {

    private static final Logger logger = LoggerFactory.getLogger("ManyOneAction");

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        logger.info("handleRequest");
        // 跳转到hello.jsp页面
        modelAndView.setViewName("message");

        return modelAndView;
    }

}

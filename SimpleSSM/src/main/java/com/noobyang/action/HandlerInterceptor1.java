package com.noobyang.action;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptor1 implements HandlerInterceptor {

    private static final Logger logger = LogManager.getLogger("HandlerInterceptor1");

    //在执行handler之前来执行的
    //用于用户认证校验、用户权限校验
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        logger.debug("HandlerInterceptor1...preHandle");

        // 如果返回false表示拦截不继续执行handler，如果返回true表示放行
        return true;
    }
    //在执行handler返回modelAndView之前来执行
    //如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现 从modelAndView入手
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("HandlerInterceptor1...postHandle");

    }
    //执行handler之后执行此方法
    //作系统 统一异常处理，进行方法执行性能监控，在preHandle中设置一个时间点，在afterCompletion设置一个时间，两个时间点的差就是执行时长
    //实现 系统 统一日志记录
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        logger.debug("HandlerInterceptor1...afterCompletion");
    }

}

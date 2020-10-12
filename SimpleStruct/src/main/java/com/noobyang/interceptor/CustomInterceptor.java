package com.noobyang.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *
 * 计时拦截器
 * Struts2自带了计时拦截器，也就是用来统计每个Action执行的时间
 *
 *
 * 执行等待拦截器
 * 如果页面执行得太慢了，Struts2还提供了执行等待拦截器，也就是说，当页面加载得太久了，
 * 就跳转到对应的提示页面…当服务器执行完毕了，也跳转到相对应的页面
 *
 *
 * Struts2防止表单重复提交拦截器
 * <interceptor-ref name="token">
 */
public class CustomInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        System.out.println("CustomInterceptor 111");
        // 调用invoke()方法，代表着放行执行下一个拦截器，如果没有拦截器了，那么就执行Action的业务代码
        invocation.invoke();
        System.out.println("CustomInterceptor 222");

        return null;
    }

}

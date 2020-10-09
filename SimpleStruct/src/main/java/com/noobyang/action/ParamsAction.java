package com.noobyang.action;

import com.noobyang.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class ParamsAction extends ActionSupport implements SessionAware, ApplicationAware, RequestAware {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String register() {

        System.out.println(user.getUsername());
        System.out.println(user.getPsd());
        System.out.println(user.getBirthday());

        // Struts 把数据保存在域对象中

        // 1. 得到 Servlet API
        // 需要导入Servlet的包，与Struts耦合了
//        ServletContext context = ServletActionContext.getServletContext();
//        HttpServletRequest request = ServletActionContext.getRequest();
//        HttpSession session = request.getSession();
//        HttpServletResponse response = ServletActionContext.getResponse();

        // 2. 得到ActionContext 对象
        // 只能在业务方法中使用ActionContext类得到对应的Map对象，如果有多个方法，那么每个方法都需要写类似的代码
//        ActionContext context = ActionContext.getContext();
//        Map<String, Object> session = context.getSession();
//        Map<String, Object> application = context.getApplication();
//        Map<String, Object> request = context.getContextMap();


        return "success";
    }

    // 3. 实现接口
    // 可以在类上定义成员变量，以至于整个类都能使用。但是需要实现类、实现对应的方法
    private Map<String, Object> application;
    private Map<String, Object> request;
    private Map<String, Object> session;
    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

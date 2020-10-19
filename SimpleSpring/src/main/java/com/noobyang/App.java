package com.noobyang;

import com.noobyang.aop.IUser;
import com.noobyang.factory.User;
import com.noobyang.injection.UserService;
import com.noobyang.injection.UserService2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {

    public static void main(String[] args) {

//        testBean(args);
//
//        testAOP(args);
//
//        testFactory(args);

//        testInjection(args);

        testInjection2(args);


    }

    /**
     * Bean工厂，BeanFactory【功能简单】
     */
    public static void testBean(String[] args) {
        // 加载Spring的资源文件
        Resource resource = new ClassPathResource("applicationContext.xml");

        // 创建IOC容器对象【IOC容器=工厂类+applicationContext.xml】
        BeanFactory beanFactory = new XmlBeanFactory(resource);
    }

    /**
     * 应用上下文，ApplicationContext【功能强大，一般我们使用这个】
     */
    public static void testAOP(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        IUser userDao = (IUser) applicationContext.getBean("user");
        System.out.println("testAOP " + userDao.getClass());
        userDao.say();

        IUser userParams = (IUser) applicationContext.getBean("userParams");
        System.out.println("testAOP " + userParams.getClass());
        userParams.say();
    }

    /**
     * 应用上下文，ApplicationContext【功能强大，一般我们使用这个】
     */
    public static void testFactory(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = (User) applicationContext.getBean("userFactory");
        System.out.println("testFactory " + user.getClass());

    }

    /**
     * 应用上下文，ApplicationContext【功能强大，一般我们使用这个】
     */
    public static void testInjection(String[] args) {
        // 创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //得到service对象
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.save();

        System.out.println("testInjection " + userService.getClass());
    }

    /**
     * 应用上下文，ApplicationContext【功能强大，一般我们使用这个】
     */
    public static void testInjection2(String[] args) {
        // 创建容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //得到service对象
        UserService2 userService = (UserService2) applicationContext.getBean("userService2");

        userService.save();

        System.out.println("testInjection2 " + userService.getClass());
    }

}

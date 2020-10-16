package com.noobyang.aop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {

    public static void main(String[] args) {

//        testAOP(args);

        testBean(args);



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

        IUser iUser = (IUser) applicationContext.getBean("userDao");
        System.out.println("main " + iUser.getClass());
        iUser.save();

    }

}

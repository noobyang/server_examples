package com.noobyang.aop2;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class ProxyFactory {

    // 维护目标对象
    private static Object target;
    // 维护关键点代码的类
    private static AOP2 aop;

    public static Object getProxyInstance(Object target_, AOP2 aop_) {

        //目标对象和关键点代码的类都是通过外界传递进来
        target = target_;
        aop = aop_;

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        aop.before();
                        Object returnValue = method.invoke(target, args);
                        aop.after();

                        return returnValue;
                    }
                }
        );
    }

}

package com.noobyang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        TestInterface testInterface = new TestConcrete();
        InvocationHandler handler = new DynamicProxy(testInterface);

        TestInterface proxyHello = (TestInterface) Proxy.newProxyInstance(
                testInterface.getClass().getClassLoader(),
                testInterface.getClass().getInterfaces(),
                handler);

        proxyHello.execute();
    }

}

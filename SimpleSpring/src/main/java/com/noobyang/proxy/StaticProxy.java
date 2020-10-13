package com.noobyang.proxy;

public class StaticProxy implements TestInterface {

    private TestInterface testInterface = new TestConcrete();

    @Override
    public void execute() {
        System.out.println("Before invoke execute" );
        testInterface.execute();
        System.out.println("Before invoke execute" );
    }


    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.execute();
    }

}

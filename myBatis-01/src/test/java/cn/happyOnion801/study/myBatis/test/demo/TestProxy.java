package cn.happyOnion801.study.myBatis.test.demo;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

class MyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}

class Demo{
    public void say(String name){
        System.out.println("I'm" + name);
    }
}

public class TestProxy {

    @Test
    public void demo(){
        Class<Demo> demo = Demo.class;
        Method[] methods = demo.getMethods();
        MyHandler handler = new MyHandler();
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].getName() == "say"){
                try {
                    methods[i].invoke(handler,"zhangaho");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

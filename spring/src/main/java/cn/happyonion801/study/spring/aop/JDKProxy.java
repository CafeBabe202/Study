package cn.happyonion801.study.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        UserDao userDao = (UserDao) Proxy.newProxyInstance(
                JDKProxy.class.getClassLoader(),
                new Class[]{UserDao.class},
                new UserDaoProxy(new UserDaoImpl()));
        int res = userDao.add(1,1);
        System.out.println("res=" + res);
    }
}

class UserDaoProxy implements InvocationHandler {

    //被代理类对象
    private Object obj;

    //把被代理对象传递进来
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * proxy：是代理类对象
         * method：是被代理类的方法对象
         * args：是形参
         */
        System.out.println("在方法执行前");
        //注意是执行obj（被代理对象）对象的方法，而不是proxy（代理对象）对象的方法
        Object res = method.invoke(obj,args);
        System.out.println("在方法执行后");
        return res;
    }
}

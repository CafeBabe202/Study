package cn.happyonion801.study.spring.aop;

import org.springframework.stereotype.Component;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("执行方法");
        return a+b;
    }

    @Override
    public String update(String id) {
        return null;
    }

    public void add(){
        System.out.println(">>add...");
    }
}

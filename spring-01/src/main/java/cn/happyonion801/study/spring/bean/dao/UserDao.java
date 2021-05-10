package cn.happyonion801.study.spring.bean.dao;

import org.springframework.stereotype.Component;

// value 值可以不写，默认是首字母小写的类名
@Component(value = "userDao1")  //<bean id="userDao1" class="cn.happyonion801.study.spring.bean.dao.USerDao"></bean>
public class UserDao {
    public void add(){
        System.out.println("UserDao add...");
    }
}

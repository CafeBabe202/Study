package cn.happyonion801.study.spring.bean.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired @Qualifier(value = "userDao1")
    private UserDao userDao1;
    @Value(value = "name")
    private String name;
    public void add(){
        System.out.println(this.name + ": UserService add...");
        userDao1.add();
    }
}

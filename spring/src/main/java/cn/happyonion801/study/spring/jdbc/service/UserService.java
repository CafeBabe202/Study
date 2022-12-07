package cn.happyonion801.study.spring.jdbc.service;

import cn.happyonion801.study.spring.jdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
/**
 * 声明是一个事务
 * 如果注解添加在类上边，那么，该类的所有方法将都启用事务
 */
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public void accountMoney(){
        userDao.reduceMoney();
       // int i = 10/0;
        userDao.addMoney();
    }
}

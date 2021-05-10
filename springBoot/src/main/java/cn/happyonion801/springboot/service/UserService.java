package cn.happyonion801.springboot.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    public void test(){
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(session);
    }
}

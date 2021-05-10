package cn.happyOnion801.study.ssm.controller;

import cn.happyOnion801.study.ssm.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    private MyBatisUtil myBatisUtil;

    @RequestMapping("/hello")
    public String helle(){
        SqlSession session = myBatisUtil.getSqlSession();
        return "hello";
    }
}
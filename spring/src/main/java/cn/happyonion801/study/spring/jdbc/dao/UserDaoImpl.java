package cn.happyonion801.study.spring.jdbc.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql = "update user set money=money-? where user_name=?";
        jdbcTemplate.update(sql,100,"mary");
    }

    @Override
    public void reduceMoney() {
        String sql = "update user set money=money+? where user_name=?";
        jdbcTemplate.update(sql,100,"lucy");
    }

    public void insert(){
        String sql = "insert user values(?,?,?)";
        jdbcTemplate.update(sql,1,"mary",1000.0);
        jdbcTemplate.update(sql,2,"lucy",1000.0);
    }
}

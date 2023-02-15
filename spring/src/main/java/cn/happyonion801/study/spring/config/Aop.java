package cn.happyonion801.study.spring.config;

import cn.happyonion801.study.spring.aop.UserDaoImpl;
import cn.happyonion801.study.spring.aop.UserDaoImplProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
public class Aop {
    @Bean
    public UserDaoImpl userDaoImpl(){
        return new UserDaoImpl();
    }
    @Bean
    public UserDaoImplProxy userDaoImplProxy(){
        return new UserDaoImplProxy();
    }
}

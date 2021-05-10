package cn.happyOnion801.study.ssm.config;

import cn.happyOnion801.study.ssm.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"cn.happyOnion801.study.ssm"})
public class SpringMVC {
    @Bean
    public User getUser() {
        return new User("MVC", 1);
    }
}

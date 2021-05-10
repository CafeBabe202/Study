package cn.happyonion801.study.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //声明是配置文件
@ComponentScan(basePackages = {"cn.happyonion801.study.spring.bean"}) //开启扫描
public class Config {

}

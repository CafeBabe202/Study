package cn.happyonion801.study.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/")
    public String HelloPage(){
        return "Hello SpringBoot";
    }
}

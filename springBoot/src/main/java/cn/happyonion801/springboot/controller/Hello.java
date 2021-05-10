package cn.happyonion801.springboot.controller;

import cn.happyonion801.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String Hello(){
        userService.test();
        return "Hello SpringBoot";
    }
}

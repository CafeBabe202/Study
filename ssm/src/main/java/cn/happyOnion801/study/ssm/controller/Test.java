package cn.happyOnion801.study.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//注意这里是 Controller
@Controller
public class Test {
    /*
        向jsp传参的两种方式，通过Model或者HttpSession类来进行传参
        配置视图解析器后直接返回视图的名字，将重定向到对应的jsp页面
     */
    @RequestMapping("/test")
    public String test(Model model, HttpSession session) {
        model.addAttribute("model", "model msg");
        session.setAttribute("msg", "666");
        return "test";
    }

    /*
        如果没有定义类型，在方法中也没有调用输出方法，将默认跳转到宇请求名相同的jsp页面
     */
    @RequestMapping("/default")
    public void defaul() {
    }

    /*
        如果你调用了输出方法，将不能进行默认的重定向
     */
    @RequestMapping("/noDefault")
    public void noDefault(HttpServletResponse response) {
        try {
            response.getOutputStream().print("noDefault");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package cn.happyOnion801.study.ssm.controller;

import cn.happyOnion801.study.ssm.pojo.Book;
import cn.happyOnion801.study.ssm.pojo.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

/*
    注意这里是 RestController
    RestController的return值将不传递给视图解析器，而是经过转换后以String的形式传递给前端
 */
@RestController
public class Hello {

    //直接返回String
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    //演示几种接受参数的形式
    //将传递的值封装成对象
    @RequestMapping("/getUser")
    public Object getUser(User user) {
        return user;
    }

    //对象的某一属性是自定义类型，如何直接赋值
    @RequestMapping("/object")
    public Object object(Book book) {
        return book;
    }

    //接受集合
    @RequestMapping("/arrayList")
    public Object arrayList(@RequestParam("arr") ArrayList list) {
        return list;
    }

    //使用map形式接受，这里必须使用 RequestParam 注解
    @RequestMapping("/map")
    public Object map(@RequestParam Map map) {
        return map.toString();
    }

    //演示如期转换类
    @RequestMapping("/date")
    public Object date(Book book) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(book.getPublicationDate());
    }

    //文件的上传
    //使用 RequestParam 将前端参数和参数名关联起来，有些地方必须加 RequestParam
    @RequestMapping("/upload")
    public String upload(@RequestParam("tx") MultipartFile[] tx) {
        String path = "/home/zhanghao/下载";
        if (tx != null) {
            System.out.println(tx.length);
            for (MultipartFile multipartFile : tx) {
                File targetFile = new File(path, multipartFile.getName());
                try {
                    multipartFile.transferTo(targetFile);
                    return "upload success";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "error";
    }

    //文件的下载
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String fileName) throws IOException {
        File file = new File("/home/zhanghao/下载/张浩201840449020.tar.gz");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", new String("文件.tar.gz".getBytes("utf-8"), "iso-8859-1"));
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.OK);
    }

    //异常处理器
    @RequestMapping("/error")
    public void error() {
        int i = 1 / 0;
    }

    //拦截器
    @RequestMapping("/inter")
    public String inter(Model model) {
        model.addAttribute("msg", "intercept fail");
        return "error";
    }

    //经过一番者折腾，还可以进行正常的使用
    public String say() {
        return "<h1>Hello</h1>";
    }
}
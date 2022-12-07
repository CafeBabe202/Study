package cn.happyOnion801.study.myBatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User2 {
    private String name;
    private int age;
    private List<Book> Books;
}

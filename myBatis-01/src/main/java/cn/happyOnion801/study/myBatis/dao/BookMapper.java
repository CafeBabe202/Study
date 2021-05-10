package cn.happyOnion801.study.myBatis.dao;

import cn.happyOnion801.study.myBatis.pojo.Book;

import java.util.List;

public interface BookMapper {
    List<Book> getList1();
    List<Book> getList2();
}

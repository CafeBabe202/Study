package cn.happyonion801.study.spring.factory;

import cn.happyonion801.study.spring.bean.Book;

public class BookFactory {

    public static Book getChineseBook(){
        return new Book("ChineseBook","Factory");
    }

    public static Book getEnglishBook(){
        return new Book("EnglishBook","Factory");
    }
}

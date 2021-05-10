package cn.happyonion801.study.spring.jdbc.dao;

import cn.happyonion801.study.spring.jdbc.entity.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int count();
    public Book get(int id);
    public List<Book> list();

    public int[] batchAdd(List<Book> books);
}

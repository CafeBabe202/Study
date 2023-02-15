package cn.happyonion801.study.spring.jdbc.service;

import cn.happyonion801.study.spring.jdbc.dao.BookDao;
import cn.happyonion801.study.spring.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookService {
    @Autowired
    private BookDao bookDao;

    //添加方法
    public int addBook(Book book){
        return bookDao.addBook(book);
    }

    public int count(){
        return bookDao.count();
    }

    public Book get(int id){
        return bookDao.get(id);
    }

    public List<Book> list(){
        return  bookDao.list();
    }

    public int[] batchAdd(List<Book> books){
        return bookDao.batchAdd(books);
    }
}

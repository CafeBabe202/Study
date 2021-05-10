package cn.happyonion801.study.spring.jdbc;

import cn.happyonion801.study.spring.config.Jdbc;
import cn.happyonion801.study.spring.jdbc.dao.UserDaoImpl;
import cn.happyonion801.study.spring.jdbc.entity.Book;
import cn.happyonion801.study.spring.jdbc.service.BookService;
import cn.happyonion801.study.spring.jdbc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void add(){
        Book book = new Book(2,"a","bc");
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.addBook(book));
    }

    @org.junit.Test
    public void count(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.count());
    }

    @org.junit.Test
    public void get(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.get(1));
    }

    @org.junit.Test
    public void list(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.list());
    }

    @org.junit.Test
    public void batchAdd(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(3,"3","3"));
        books.add(new Book(4,"4","4"));
        books.add(new Book(5,"5","5"));
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(Arrays.toString(bookService.batchAdd(books)));
    }

    @org.junit.Test
    public void insetUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        UserDaoImpl userDaoImpl = context.getBean("userDaoImpl", UserDaoImpl.class);
        userDaoImpl.insert();
    }

    @org.junit.Test
    public void accountMoney(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @org.junit.Test
    public void xmlAccountMoney(){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.accountMoney();
    }

    @org.junit.Test
    public void AnnotationAccountMoney(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Jdbc.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();

    }

}

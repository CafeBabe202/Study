package cn.happyonion801.study.spring.jdbc.dao;

import cn.happyonion801.study.spring.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addBook(Book book) {
        String sql = "insert into book values(?,?,?)";
        /**
         * 更新操作，用来增删改
         * arg 1 ： sql语句
         * arg ... ： sql参数
         */
        return jdbcTemplate.update(sql, book.getId(), book.getBook_status(), book.getBook_name());
    }

    @Override
    public int count() {
        /**
         * 用来获取单一的数值，比如查看一共多少条数据
         * arg 1 ： sql语句
         * arg 2 ： 返回值的类型的Class
         */
        String sql = "select count(*) from book";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Book get(int id) {
        /**
         * 用来查询一个对象
         * arg 1 ： sql语句
         * arg 2 ： 一个BeanPropertyRowMapper，相当于设置返回值类型
         * arg ... ： sql参数
         */
        String sql = "select * from book where id = ?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> list() {
        /**
         * 用来查询集合
         * arg 1 ： sql语句
         * arg 2 ： 一个BeanPropertyRowMapper，相当于设置返回值类型
         * arg ... ： sql参数 （ 由于这里没有参数，所以没有写 ）
         */
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public int[] batchAdd(List<Book> books) {
        /**
         * 批量添加操作,删改也是同样的操作，就不演示了；查询的话不涉及批量操作
         * arg 1 ： sql语句
         * arg 2 ： 是一个List<Object[]>类型，每一个Object[]就一组args，然后遍历list循环进行操作
         */
        String sql = "insert into book value(?,?,?)";
        List<Object[]> args = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            Object[] arg = {book.getId(), book.getBook_status(), book.getBook_name()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }
}

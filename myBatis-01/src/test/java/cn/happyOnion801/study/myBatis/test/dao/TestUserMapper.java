package cn.happyOnion801.study.myBatis.test.dao;

import cn.happyOnion801.study.myBatis.dao.BlogMapper;
import cn.happyOnion801.study.myBatis.dao.BookMapper;
import cn.happyOnion801.study.myBatis.dao.User2Mapper;
import cn.happyOnion801.study.myBatis.dao.UserMapper;
import cn.happyOnion801.study.myBatis.pojo.Book;
import cn.happyOnion801.study.myBatis.pojo.User;
import cn.happyOnion801.study.myBatis.utils.MyBatisUtils;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//使用Lombok添加 logger
@Log4j
public class TestUserMapper {

    @Test
    public void getUserList() {
        SqlSession session = MyBatisUtils.getSqlSession();
        /*
         * SqlSession 是一个 DefaultSqlSession 类，由 DefaultSqlSessionFactory 创建
         *
         * 获取代理对象时，首先调用 Configuration.mapperRegistry 的
         *      getMapper(Class<T> type, SqlSession sqlSession)
         *      该方法会创建一个 MapperProxyFactory<T> 并调用
         *      T newInstance(SqlSession sqlSession)
         *          mapperProxy = new MapperProxy<>(sqlSession, mapperInterface, methodCache)
         *      T newInstance(MapperProxy<T> mapperProxy)
         *      Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy)
         *      MapperProxy<T> 实现了 InvocationHandler 接口
         */
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);
        session.close();//记得关闭资源
    }

    @Test
    public void getUserByName() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByName("卢亚男");
        System.out.println(user);
        session.close();//记得关闭资源
    }

    @Test
    public void getUserByNameLike() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByNameLike("张");
        System.out.println(user);
        session.close();//记得关闭资源
    }

    @Test
    public void insertUser() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUser(new User("张浩", 22));
        session.commit();//注意增删改方法一定要进行事物的提交
        session.close();//记得关闭资源
    }

    @Test
    public void insertUserByMap() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("年龄", 22);
        map.put("姓名", "梁讯聪");
        mapper.insertUserByMap(map);
        session.commit();//注意增删改方法一定要进行事物的提交
        session.close();//记得关闭资源
    }

    @Test
    public void deleteUserByName() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUserByName("梁讯聪");
        session.commit();//注意增删改方法一定要进行事物的提交
        session.close();//记得关闭资源
    }

    @Test
    public void updateUserByName() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUserByName(new User("张浩", 20));
        session.commit();//注意增删改方法一定要进行事物的提交
        session.close();//记得关闭资源
    }

    @Test
    public void log4j() {
        log.info("这是一个info日志");
        log.error("这是一个error日志");
        log.debug("这是一个debug日志");
    }

    @Test
    public void limit() {
        SqlSession session = MyBatisUtils.getSqlSession();
        /*
         * 通过 RowBounds 来进行分页处理
         * 这种方式不是很好，不建议使用，但是如果使用分页插件的话就需要使用这种方式
         * 如果项目不是很大，还是要使用 limit 的方式进行分页比较好
         */
        RowBounds bounds = new RowBounds(0, 2);
        //第一个参数是 接口的全类名.方法名
        List<User> users = session.selectList("cn.happyOnion801.study.myBatis.dao.UserMapper.getUserList", null, bounds);
        users.forEach(System.out::println);
    }

    @Test
    public void lombok() {
        log.info("lombok Log4j");
    }

    @Test
    public void getBook() {
        SqlSession session = MyBatisUtils.getSqlSession();
        BookMapper mapper = session.getMapper(BookMapper.class);
        List<Book> list = mapper.getList1();
        list.forEach(System.out::println);
        System.out.println(list.get(0).getUser() == list.get(1).getUser());

        list = mapper.getList2();
        list.forEach(System.out::println);
        System.out.println(list.get(0).getUser() == list.get(1).getUser());
        session.close();
    }

    @Test
    public void getUser() {
        SqlSession session = MyBatisUtils.getSqlSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        mapper.getUser1().forEach(System.out::println);
        System.out.println("=========");
        mapper.getUser2().forEach(System.out::println);
    }

    @Test
    public void getBlog() {
        SqlSession session = MyBatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        List<String> authors = new ArrayList<>();
        authors.add("张浩");
        authors.add("景浩");
        map.put("authors", authors);
        map.put("title", "java");
        mapper.getBlog(map).forEach(System.out::println);
    }

    @Test
    public void twoCache() {
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.getUserList().forEach(System.out::println);
        session.commit();
        session.close();

        session = MyBatisUtils.getSqlSession();
        mapper = session.getMapper(UserMapper.class);
        mapper.getUserList().forEach(System.out::println);
    }

    @Test
    public void testGenerator() {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("/home/zhanghao/IdeaProjects/Study/myBatis-01/src/main/resources/generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        try {
            Configuration configuration = configurationParser.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

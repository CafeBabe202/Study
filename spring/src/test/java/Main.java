import cn.happyonion801.study.spring.aop.UserDao;
import cn.happyonion801.study.spring.aop.UserDaoImpl;
import cn.happyonion801.study.spring.bean.*;
import cn.happyonion801.study.spring.bean.dao.UserService;
import cn.happyonion801.study.spring.config.Aop;
import cn.happyonion801.study.spring.config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    @Test //演示使用set注入属性
    public void main1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book1", Book.class);
        System.out.println(book);
    }

    @Test
    public void factory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(context.getBean("reader1", Reader.class));
        System.out.println(context.getBean("reader2", Reader.class));
    }

    @Test //使用构造器进行属性注入
    public void main2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book2", Book.class);
        System.out.println(book);
    }

    @Test //使用set注入 简化版
    public void main3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book3", Book.class);
        System.out.println(book);
    }

    @Test //设置null
    public void main4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book4", Book.class);
        System.out.println(book);
    }

    @Test //设置特殊字符
    public void main5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book5", Book.class);
        System.out.println(book);
    }

    @Test //注入外部bean
    public void main6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book6", Book.class);
        System.out.println(book);
    }

    @Test //注入内部bean
    public void main7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Emp emp = context.getBean("emp1", Emp.class);
        System.out.println(emp);
    }

    @Test //注入内部bean
    public void main8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Emp emp = context.getBean("emp2", Emp.class);
        System.out.println(emp);
    }

    @Test //注入集合类
    public void main9() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Stu stu = context.getBean("stu1", Stu.class);
        System.out.println(stu);
    }

    @Test //在集合中注入对象
    public void main10() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Stu stu = context.getBean("stu2", Stu.class);
        System.out.println(stu);
    }

    @Test //将集合提取出来
    public void main11() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Stu stu = context.getBean("stu2", Stu.class);
        System.out.println(stu);
    }

    @Test //FactoryBean
    public void main12() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("myBean1", Book.class);
        System.out.println(book);
    }

    @Test //多实例bean
    public void main13() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book1 = context.getBean("book7", Book.class);
        System.out.println(book1);
        Book book2 = context.getBean("book7", Book.class);
        System.out.println(book2);
    }

    @Test //bean的生命周期
    public void main14() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Orders orders = context.getBean("orders1", Orders.class);
        orders.test();
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test //自动注入
    public void main15() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Emp emp = context.getBean("emp3", Emp.class);
        System.out.println(emp);
    }

    @Test //bean引入外部properties
    public void main16() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Book book = context.getBean("book8", Book.class);
        System.out.println(book);
    }

    @Test //使用注解创建bean
    public void main17() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = context.getBean("userDao1", UserDao.class);
        userDao.add(1, 2);
    }

    @Test //使用注解进行属性注入
    public void main18() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test //使用完全注解开发
    public void main19() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test //AOP xml
    public void main20() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        UserDaoImpl userDao = context.getBean("userDaoImpl", UserDaoImpl.class);
        userDao.add();
    }

    @Test //完全注解
    public void main21() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Aop.class);
        UserDaoImpl userDao = context.getBean(UserDaoImpl.class);
        userDao.add();
    }
}

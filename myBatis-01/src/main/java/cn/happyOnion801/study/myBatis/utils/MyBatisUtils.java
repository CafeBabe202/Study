package cn.happyOnion801.study.myBatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {
    /**
     * MyBatis的核心是SqlSessionFactory和SqlSession
     * 可一使用SqlSessionFactoryBuilder通过配置文件来创建一个SqlSessionFactory
     * SqlSessionFactory可以用来创建SqlSession
     * SqlSession类型PrepareStatement，可以用来对数据库进操作
     * SqlSession的getMapper方法可以直接返回配置好的Dao接口的一个实体类
     *
     * 生命周期和作用域
     * SqlSessionFactoryBuilder 只是用来构建 SqlSessionFactory 的一个工具，只要 SqlSessionFactory 构建完成之后就不再需要了
     *
     * SqlSessionFactory 相当于一个数据库连接池，每次构建 SqlSession 都要使用，生命周期应该贯穿真个应用程序的生命周期
     *
     * SqlSession 就好像是一个数据库连接对象，用来构建 Mapper 对象
     * SqlSession 可以多次构建出不同的 Mapper 对象
     * SqlSession 不是线程安全的，并且使用完成之后应该及时的关闭，防止浪费资源
     * SqlSession 作用域与应该为请求域
     *
     * Mapper对象就是自定的接口的一个实例对象，相当于以前的 BeanDaoImpl 对象
     */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}

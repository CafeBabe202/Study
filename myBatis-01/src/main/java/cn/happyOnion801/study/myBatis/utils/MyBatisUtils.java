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
            /**
             * 建造者模式
             * 创建一个 SqlSessionFactoryBuilder 用于创建 SqlSessionFactory
             */
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            /**
             * SqlSessionFactoryBuilder通过Build方法传入一个流对象
             *
             * 调用 SqlSessionFactoryBuilder 的
             *      SqlSessionFactory build(InputStream inputStream, String environment, Properties properties)
             *      environment 和 properties 使用 null
             *
             * 然后，使用 environment 和 properties 通过
             *      XMLConfigBuilder(InputStream inputStream, String environment, Properties props)
             *      XMLConfigBuilder(XPathParser parser, String environment, Properties props)
             *      方法来创建一个 XMLConfigBuilder 对象来解析 xml 文件
             *      XPathParser 和 XNode 真正封装了解析 xml 文件的工作，
             *
             * XMLConfigBuilder 的
             *      Configuration parse()
             *      void parseConfiguration(XNode root)
             *      负责解析 xml 文件，并标记一个文件是否解析过，如果解析过 将提示 "Each XMLConfigBuilder can only be used once."
             *      解析完成后，将返回一个 Configuration 对象，这个对象包含了 Environment 等其他环境相关的信息
             *
             * 最后，将这个 Configuration 赋值给 SqlSessionFactory 对象并返回
             */
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        /**
         * SqlSession 实际上一个 DefaultSqlSessionFactory 对象，由 SqlSessionFactoryBuilder 的
         *      SqlSessionFactory build(Configuration config)
         *      方法通过 XPathParser 解析出来的 Configuration 创建
         *
         * sqlSessionFactory 的
         *      SqlSession openSession()
         *      this.openSessionFromDataSource(this.configuration.getDefaultExecutorType(), (TransactionIsolationLevel)null, false)
         *          Executor executor = this.configuration.newExecutor(tx, execType)
         *      new DefaultSqlSession(this.configuration, executor, autoCommit)
         *      executor 能够通过 Configuration 中的 Environment 从数据库连接池中获取 Statement 执行 sql
         */
        return sqlSessionFactory.openSession();
    }
}

package cn.happyOnion801.study.ssm.dataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class DruidDataSource implements DataSourceFactory {

    private DataSource source;

    @Override
    public void setProperties(Properties properties) {
        try {
            this.source = com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.source);
    }

    @Override
    public DataSource getDataSource() {
        return this.source;
    }
}

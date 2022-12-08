package top.cafebabe202.study.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

public class HDFS {

    FileSystem fs;

    @Before
    public void before() throws Exception {
        URI uri = new URI("hdfs://hp0:8020");
        Configuration configuration = new Configuration();
        fs = FileSystem.get(uri, configuration, "zh");
    }

    @After
    public void after() throws Exception {
        fs.close();
    }

    @Test
    public void mkdir() throws Exception {
        fs.mkdirs(new Path("/api_test"));
    }

    @Test
    public void delete() throws Exception {
        fs.delete(new Path("/output"), true);
    }

    @Test
    public void upload() throws Exception {
        fs.moveFromLocalFile(new Path("D:\\下载\\Compressed\\hadoop-3.3.4.tar.gz"), new Path("/api_test"));
    }

    @Test
    public void download() throws Exception {
        fs.copyToLocalFile(new Path("/api_test/hadoop-3.3.4.tar.gz"), new Path("D:\\a.tar.gz"));
    }

    @Test
    public void rename() throws Exception{
        fs.rename(new Path("/api_test/hadoop-3.3.4.tar.gz"), new Path("/api_test/hadoop.tar.gz"));
    }
}

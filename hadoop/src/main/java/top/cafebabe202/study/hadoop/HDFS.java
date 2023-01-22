package top.cafebabe202.study.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

public class HDFS {

    FileSystem fs;

    @Before
    public void before() throws Exception {
        URI uri = new URI("hdfs://hadoop102:8020");
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
        fs.moveFromLocalFile(new Path("D:\\Jar\\Mindustry.jar"), new Path("/api_test"));
    }

    @Test
    public void download() throws Exception {
        fs.copyToLocalFile(new Path("/api_test/hadoop-3.3.4.tar.gz"), new Path("D:\\a.tar.gz"));
    }

    @Test
    public void rename() throws Exception {
        fs.rename(new Path("/api_test/hadoop-3.3.4.tar.gz"), new Path("/api_test/hadoop.tar.gz"));
    }

    @Test
    public void fileDetail() throws IOException {
        RemoteIterator<LocatedFileStatus> statusIterator
                = fs.listFiles(new Path("/api_test"), false);
        while (statusIterator.hasNext()) {
            LocatedFileStatus next = statusIterator.next();
            System.out.println(
                    next.getPath() +
                            "\t" + next.isDirectory() +
                            "\t" + next.getPermission() +
                            "\t" + next.getOwner() +
                            "\t" + next.getGroup() +
                            "\t" + next.getLen() +
                            "\t" + next.getModificationTime() +
                            "\t" + next.getReplication() +
                            "\t" + next.getBlockSize() +
                            "\t" + Arrays.toString(next.getBlockLocations())
            );
        }
    }

    @Test
    public void isDir() throws IOException {
        FileStatus[] fileStatuses = fs.listStatus(new Path("/api_test"));
        for (FileStatus fileStatus : fileStatuses) {
            System.out.println((fileStatus.isDirectory() ? "" : "不") + "是目录");
        }
    }
}

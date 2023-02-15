package top.cafebabe202.study.hadoop.mapJoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MapJoinDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, URISyntaxException {
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(MapJoinDriver.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setMapperClass(MapJoinMapper.class);

        FileInputFormat.setInputPaths(job, new Path("/home/zh/hadoop/input/004/input"));
        FileOutputFormat.setOutputPath(job, new Path("/home/zh/hadoop/output/004"));

        // 设置需要缓存的文件
        job.addCacheFile(new URI("file:///home/zh/hadoop/input/004/catch/pid"));

        // 这个比较简单，不进行 Reduce 操作
        job.setNumReduceTasks(0);

        boolean res = job.waitForCompletion(true);
        System.out.println(res ? "success" : "fail");
        System.exit(res ? 0 : 1);
    }
}

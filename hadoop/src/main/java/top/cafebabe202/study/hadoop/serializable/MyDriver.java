package top.cafebabe202.study.hadoop.serializable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MyDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {


        // 创建 job 对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        // 设置启动类
        job.setJarByClass(MyDriver.class);

        // 设置 map 和 reduce 类
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);

        // 设置 map 和最终的 K,V 输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        // 设置输出输出路径
        FileInputFormat.setInputPaths(job, new Path("/home/zh/hadoop/input/001"));
        FileOutputFormat.setOutputPath(job, new Path("/home/zh/hadoop/output/001"));

        //提交任务
        boolean b = job.waitForCompletion(true);
        System.out.println(b ?"Successful":"fail");
        System.exit(b ? 0 : 1);
    }
}
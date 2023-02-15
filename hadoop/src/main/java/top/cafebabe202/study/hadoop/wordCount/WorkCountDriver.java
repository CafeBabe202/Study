package top.cafebabe202.study.hadoop.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


// 任务的总流程，都差不多吧，八股
public class WorkCountDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        // 创建 job 对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        // 设置启动类
        job.setJarByClass(WorkCountDriver.class);

        // 设置 map 和 reduce 类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 设置 map 和最终的 K,V 输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 设置输出输出路径
        FileInputFormat.setInputPaths(job, new Path("/home/zh/hadoop/input/000"));
        FileOutputFormat.setOutputPath(job, new Path("/home/zh/hadoop/output/001"));

        //提交任务
        boolean b = job.waitForCompletion(true);
        System.out.println(b ? "Successful" : "fail");
        System.exit(b ? 0 : 1);
    }
}



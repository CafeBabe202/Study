package top.cafebabe202.study.hadoop.outputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class OutputFormatDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // 获取工作对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        // 设置主类
        job.setJarByClass(OutputFormatDriver.class);

        // 设置 map 和 reducer
        job.setMapperClass(OutputFormatMapper.class);
        job.setReducerClass(OutputFormatReducer.class);

        // 设置 map 和 最终的 K,V 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        // 设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("D:\\hadoop\\input\\outputFormat"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\hadoop\\output\\outputFormat"));

        //提交执行
        boolean isSuccess = job.waitForCompletion(true);
        System.out.println(isSuccess ? "success" : "fail");
        System.exit(isSuccess ? 0 : 1);
    }
}

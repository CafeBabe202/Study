package top.cafebabe202.study.hadoop.outputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class LogDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(LogDriver.class);

        job.setMapperClass(LogMapper.class);
        job.setReducerClass(LogReducer.class);
        job.setOutputFormatClass(LogFileOutputFormat.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job, new Path("/home/zh/hadoop/input/002"));
        FileOutputFormat.setOutputPath(job, new Path("/home/zh/hadoop/output/002"));

        boolean res = job.waitForCompletion(true);
        System.out.println(res ? "Successful" : "fail");
        System.exit(res ? 0 : 1);
    }
}

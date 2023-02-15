package top.cafebabe202.study.hadoop.JoinTable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class JoinDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(JoinDriver.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TableBean.class);
        job.setOutputKeyClass(TableBean.class);
        job.setOutputValueClass(NullWritable.class);

        job.setMapperClass(JoinMapper.class);
        job.setReducerClass(JoinReducer.class);

        FileInputFormat.setInputPaths(job, new Path("/home/zh/hadoop/input/003/"));
        FileOutputFormat.setOutputPath(job, new Path("/home/zh/hadoop/output/003/"));

        boolean res = job.waitForCompletion(true);
        System.out.println(res ? "Successful" : "fail");
        System.exit(res ? 0 : 1);
    }
}

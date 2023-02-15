package top.cafebabe202.study.hadoop.outputFormat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


// 其实这个类只是一个壳，并没有真正的写出数据，而是通过这个类获取一个 RecordWriter 类来真正的进行输出
// 为啥要这样设计呢？
public class LogFileOutputFormat extends FileOutputFormat<Text, NullWritable> {
    @Override
    public RecordWriter<Text, NullWritable> getRecordWriter(TaskAttemptContext job) {
        return new LogRecordWrite(job);
    }
}

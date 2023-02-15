package top.cafebabe202.study.hadoop.outputFormat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

// 这是真正向外输出数据的类，泛型是输入数据的类型
public class LogRecordWrite extends RecordWriter<Text, NullWritable> {
    private final FSDataOutputStream atguiguOut;
    private final FSDataOutputStream otherOut;

    // 一个构造器，传过来的是 context，里面包含了任务信息
    public LogRecordWrite(TaskAttemptContext context) {
        try {

            // 通过 context 的配置信息创建一个 FS 的对象，用来输出数据，这里不能用 java.io 包下的，因为生产环境会存放在 Hadoop 集群上
            FileSystem fileSystem = FileSystem.get(context.getConfiguration());

            // 创建连个流
            this.atguiguOut = fileSystem.create(new Path("/home/zh/hadoop/output/002/atguigu"));
            this.otherOut = fileSystem.create(new Path("/home/zh/hadoop/output/002/other"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(Text key, NullWritable value) {
        String log = key.toString();
        try {
            if (log.contains("atguigu")) {
                this.atguiguOut.writeBytes(log + "\n");
            } else {
                this.otherOut.writeBytes(log + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void close(TaskAttemptContext context) {
        IOUtils.closeStream(this.atguiguOut);
        IOUtils.closeStream(this.otherOut);
    }
}

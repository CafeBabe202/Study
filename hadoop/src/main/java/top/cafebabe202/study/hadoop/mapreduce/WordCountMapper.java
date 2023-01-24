package top.cafebabe202.study.hadoop.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// 继承 Mapper 类型。四个泛型，是输入输出的 KV 类型
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    // 创建两个变量，用于将本 map 的信息输出，写成公共变量可以减少对象的创建，提高性能
    // 因为每次写出的时候都是将对象进行序列化，写出之后并不会依赖原对象，所以可以使用同一个对象
    private final Text outK = new Text();
    private final IntWritable outV = new IntWritable(1);

    /**
     * @param key     在数据块中的字节偏移量
     * @param value   该 Map 的输入值，我觉得应该也可以是二进制流吧，不能只能处理文本数据吧，我觉得这个 value 每次的值应该按照类型进行分割吧，Text 类型是按照行划分的，不知道二进制数据分怎么划分
     * @param context 上下文对象，用于向 reduce 传输数据，也包含该任务相关的配置信息
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // 这里每次都是传递过来一行文本信息，所以要将一行文本拆分成多个单词
        String[] words = value.toString().split(" ");
        for (String word : words) {
            this.outK.set(word);

            // 每一个单词都是第一次出现，所以每个单词次数都是 1，相同的单词会有多个 key/value 对
            context.write(outK, outV);
        }
    }
}

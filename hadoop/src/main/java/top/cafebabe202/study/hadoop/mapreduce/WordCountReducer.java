package top.cafebabe202.study.hadoop.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

// 四个参数，分别是输入输出的 KV 类型，我举得这个输入的 KV 应该和 map 的输出 KV 类型一样吧。
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private final IntWritable outV = new IntWritable();

    /**
     * @param text    map 输出的 K，每个 K 只传入一次
     * @param values  map 输出中每个 K 的所有 value 值的集合
     * @param context 上下文对象，用于向 reduce 传输数据，也包含该任务相关的配置信息
     */
    @Override
    public void reduce(Text text, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        this.outV.set(sum);
        context.write(text, outV);
    }
}
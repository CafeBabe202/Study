package top.cafebabe202.study.hadoop.serializable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    // 依旧是定义变量，用来写出数据
    private final FlowBean bean;
    private final Text key;

    public MyMapper() {
        this.bean = new FlowBean();
        this.key = new Text();
    }

    // 这里和 wordCount 十分相似，就是将 value 的 IntWrite 类型换成了自己编写的 FlowBean
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        String[] strs = value.toString().split("\t");
        this.key.set(strs[1]);
        this.bean.setUpSum(Integer.parseInt(strs[strs.length - 3]));
        this.bean.setDownSum(Integer.parseInt(strs[strs.length - 2]));
        context.write(this.key, this.bean);
    }
}

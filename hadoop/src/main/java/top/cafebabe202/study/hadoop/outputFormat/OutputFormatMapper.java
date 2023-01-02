package top.cafebabe202.study.hadoop.outputFormat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OutputFormatMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    private final Text outK = new Text();
    private final FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] strs = value.toString().split("\t");
        this.outV.setUp(Integer.parseInt(strs[1]));
        this.outV.setDown(Integer.parseInt(strs[2]));
        this.outK.set(strs[0]);
        context.write(this.outK, this.outV);
    }
}

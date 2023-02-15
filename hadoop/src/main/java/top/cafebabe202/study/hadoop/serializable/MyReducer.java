package top.cafebabe202.study.hadoop.serializable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
    private final FlowBean bean;

    public MyReducer() {
        this.bean = new FlowBean();
    }

    // 这里的 key value 和 wordCount 十分相似
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        int downSum = 0, upSum = 0;

        // 将所有的上下行流量都加在一起
        for (FlowBean value : values) {
            System.out.println(value);
            upSum += value.getUpSum();
            downSum += value.getDownSum();
        }
        this.bean.setUpSum(upSum);
        this.bean.setDownSum(downSum);
        context.write(key, this.bean);
    }
}

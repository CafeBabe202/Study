package top.cafebabe202.study.hadoop.outputFormat;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class OutputFormatReducer extends Reducer<Text, FlowBean, FlowBean, Text> {
    private final FlowBean outK = new FlowBean();

    @Override
    public void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        int sumUp = 0;
        int sumDown = 0;
        for (FlowBean value : values) {
            sumUp += value.getUp();
            sumDown += value.getDown();
        }
        this.outK.setUp(sumUp);
        this.outK.setDown(sumDown);
        context.write(outK, key);

    }
}

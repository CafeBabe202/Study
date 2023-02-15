package top.cafebabe202.study.hadoop.JoinTable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class JoinMapper extends Mapper<LongWritable, Text, Text, TableBean> {

    private String flag;
    private final Text outKey = new Text();
    private final TableBean outValue = new TableBean();

    @Override
    public void setup(Context context) {
        FileSplit fileSplit = (FileSplit) context.getInputSplit();
        this.flag = fileSplit.getPath().getName();
    }

    @Override
    public void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, TableBean>.Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\t");
        this.outValue.setFlag(this.flag);

        // 不管是那个表的数据都塞在 TableBean
        if (this.flag.contains("order")) {
            this.outValue.setOrder(split[0]);
            this.outValue.setPid(split[1]);
            this.outValue.setAmount(Integer.parseInt(split[2]));
            this.outValue.setName(""); // 由于要进行输出，所以不能有 null，所以要赋空值
        } else {
            this.outValue.setOrder("");
            this.outValue.setPid(split[0]);
            this.outValue.setAmount(0);
            this.outValue.setName(split[1]);
        }
        this.outKey.set(this.outValue.getPid());
        context.write(this.outKey, this.outValue);
    }
}

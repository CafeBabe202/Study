package top.cafebabe202.study.hadoop.serializable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 创建一个 FlowBean 类，用来存储每个手机号的信息。
 */
public class FlowBean implements Writable {

    // 定义相关的属性，分别用来存储上行总和、下行总和
    private int upSum;
    private int downSum;

    // 必须要有一个空参构造器
    public FlowBean() {
    }

    public int getUpSum() {
        return upSum;
    }

    public void setUpSum(int upSum) {
        this.upSum = upSum;
    }

    public int getDownSum() {
        return downSum;
    }

    public void setDownSum(int downSum) {
        this.downSum = downSum;
    }

    @Override
    public void write(DataOutput out) throws IOException {

        // 写出各个需要进行序列化的属性，这里的顺序可以随意；写出 int 类型使用 writeInt 方法
        out.writeInt(this.upSum);
        out.writeInt(this.downSum);
    }

    @Override
    public void readFields(DataInput in) throws IOException {

        // 读取一个整形；注意这里的顺序，要和上边写出的顺序相同，先写先读
        this.upSum = in.readInt();
        this.downSum = in.readInt();
    }

    @Override
    public String toString() {

        // 在输出到文件的时候将调用 toString 方法，总和是在这里进行计算的
        return this.upSum + "\t" + this.downSum + "\t" + (this.upSum + this.downSum);
    }
}

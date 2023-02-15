package top.cafebabe202.study.hadoop.JoinTable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TableBean implements Writable {

    private String order;
    private String pid;
    private int amount;
    private String name;
    private String flag;

    public TableBean() {
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(this.order);
        out.writeUTF(this.pid);
        out.writeInt(this.amount);
        out.writeUTF(this.name);
        out.writeUTF(this.flag);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.order = in.readUTF();
        this.pid = in.readUTF();
        this.amount = in.readInt();
        this.name = in.readUTF();
        this.flag = in.readUTF();
    }

    @Override
    public String toString() {
        return this.order + "\t" + this.name + "\t" + this.amount;
    }
}

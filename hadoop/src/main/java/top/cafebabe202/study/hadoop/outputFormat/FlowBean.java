package top.cafebabe202.study.hadoop.outputFormat;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class FlowBean implements WritableComparable<FlowBean> {
    private int up;
    private int down;

    public FlowBean() {
        super();
    }

    public FlowBean(int up, int down) {
        this.up = up;
        this.down = down;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getSum() {
        return this.down + this.up;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowBean)) return false;
        FlowBean flowBean = (FlowBean) o;
        return getUp() == flowBean.getUp() && getDown() == flowBean.getDown();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUp(), getDown());
    }

    @Override
    public String toString() {
        return this.up + "\t" + this.down;
    }

    @Override
    public int compareTo(FlowBean o) {
        return Integer.compare(o.getSum(), this.getSum());
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.up);
        out.writeInt(this.down);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.up = in.readInt();
        this.down = in.readInt();
    }
}

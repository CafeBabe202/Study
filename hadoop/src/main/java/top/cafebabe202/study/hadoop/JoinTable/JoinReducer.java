package top.cafebabe202.study.hadoop.JoinTable;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class JoinReducer extends Reducer<Text, TableBean, TableBean, NullWritable> {
    @Override
    public void reduce(Text key, Iterable<TableBean> values, Reducer<Text, TableBean, TableBean, NullWritable>.Context context) throws IOException, InterruptedException {
        TableBean nameBean = new TableBean();
        List<TableBean> beans = new LinkedList<>();

        // 遍历所有的对象，将标记了名称的对象找出来
        for (TableBean value : values) {
            if (value.getFlag().contains("order")) {
                TableBean bean = new TableBean();
                try {
                    BeanUtils.copyProperties(bean, value); // 这里要对象复制，并不能直接添加 value 对象，因为每次返回的 value 对象相同，只是状态不同
                    beans.add(bean);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    BeanUtils.copyProperties(nameBean, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // 循环输出每一个对象
        for (TableBean bean : beans) {
            bean.setName(nameBean.getName()); //  记得设置名称
            context.write(bean, NullWritable.get());
        }
    }
}

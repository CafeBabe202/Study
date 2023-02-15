package top.cafebabe202.study.hadoop.mapJoin;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MapJoinMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private final Map<String, String> map = new HashMap<>();
    private final Text outKey = new Text();

    @Override
    protected void setup(Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException {

        // 在 setup 中对缓存文件进行处理，添加 Map 中方便使用
        URI[] cacheFiles = context.getCacheFiles();
        FileSystem fileSystem = FileSystem.get(context.getConfiguration());
        FSDataInputStream fsDataInputStream = fileSystem.open(new Path(cacheFiles[0]));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsDataInputStream, StandardCharsets.UTF_8));

        String line;
        while (StringUtils.isNotEmpty(line = bufferedReader.readLine())) {
            String[] split = line.split("\t");
            this.map.put(split[0], split[1]);
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\t");

        // 通过刚刚的缓存对文件进行 join 操作
        this.outKey.set(split[0] + "\t" + this.map.get(split[1]) + "\t" + split[2]);
        context.write(this.outKey, NullWritable.get());
    }
}

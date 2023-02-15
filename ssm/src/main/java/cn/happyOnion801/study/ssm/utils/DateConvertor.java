package cn.happyOnion801.study.ssm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定义一个日期转换类，将从前端接受的字符串类型适配成controller方法中的Date类型
 * 要想配置文件起作用，你需要在springMVC的配置文件中进行相应的配置
 */
public class DateConvertor implements Converter<String, Date> {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String s) {
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

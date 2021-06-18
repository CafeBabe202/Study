package cn.happyOnion801.study.myBatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 使用 Lombok 注解进行自动生成一些方法
 * 具体的注解请参见 google
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private int age;
}

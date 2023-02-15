package cn.happyOnion801.study.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private User reader;
    //可以通过注解实现类型的适配，但是多了就很烦
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
}

package cn.happyonion801.study.spring.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    private String[] course;
    private Set<String> set;
    private List<String> list;
    private Map<String,String> map;
    private List<Book> books;

    public void setCourse(String[] course){
        this.course = course;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "course=" + Arrays.toString(course) +
                ", set=" + set +
                ", list=" + list +
                ", map=" + map +
                ", books=" + books +
                '}';
    }
}

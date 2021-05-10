package cn.happyOnion801.study.myBatis.dao;

import cn.happyOnion801.study.myBatis.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    List<Blog> getBlog(Map map);
}

package cn.happyOnion801.study.myBatis.utils;

import org.apache.ibatis.cache.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

public class MyCache implements Cache {

    private Map<Object, Object> map;
    private String id;

    public MyCache(String id) {
        this.id = id;
        this.map = new HashMap<>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        map.put(o, o1);
    }

    @Override
    public Object getObject(Object o) {
        return map.get(o);
    }

    @Override
    public Object removeObject(Object o) {
        return map.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int getSize() {
        return map.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}

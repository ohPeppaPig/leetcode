package 高频面试;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    Map<Integer,Integer> cache = new HashMap<>();
    LinkedList<Integer> list = new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        if(cache.containsKey(key)){
            list.remove((Integer) key);
            list.addLast(key);
           return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        // 存在
        if(cache.containsKey(key)){
            cache.put(key,value);
            list.remove((Integer)key);
            list.addLast(key);
            return;
        }
        int size = cache.size();
        if(size<capacity){
            cache.put(key,value);
            list.addLast(key);
        }else {
           int isdel =  list.get(0);
           cache.remove(isdel);
           cache.put(key,value);
           list.remove(0);
           list.addLast(key);
        }
    }

    }

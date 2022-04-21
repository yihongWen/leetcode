package zyj.yihong.leetcode.mid.queue;

import java.util.*;

public class LRUCache146 {

    private Map<Integer,Integer> map;
    private LinkedList<Integer> queue;
    private int capacity;
    public LRUCache146(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int ans = -1;
        if (map.containsKey(key)){
            ans = map.get(key);
            // 加载到队列头部
            queue.remove((Object)(key));
            queue.addFirst(key);
        }
        return ans;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key,value);
            queue.remove((Object)(key));
            queue.addFirst(key);
            return;
        }

        if (map.size()==capacity){
            Integer last = queue.getLast();
            map.remove(last);
            queue.removeLast();
        }

        // 添加key
        map.put(key,value);
        queue.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache146 lruCache146 = new LRUCache146(2);
//        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

        lruCache146.put(1,1);
        lruCache146.put(2,2);
        lruCache146.get(1);
        lruCache146.put(3,3);
        lruCache146.get(2);
        lruCache146.put(4,4);
        lruCache146.get(1);
        lruCache146.get(3);
        lruCache146.get(4);


    }

}

package zyj.yihong.leetcode.random_select;

import java.util.HashMap;
import java.util.Map;

// 677. 键值映射
//设计一个 map ，满足以下几点:
//
//字符串表示键，整数表示值
//返回具有前缀等于给定字符串的键的值的总和
public class MapSum_M_667 {
    TrieNode root;
    Map<String, Integer> map;

    // 前缀，使用字典的方式（也可以暴力）
    public MapSum_M_667() {
        map = new HashMap<>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        // 判断当前key是否存在map中
        Integer originNum = map.getOrDefault(key, 0);
        int handleNum = val-originNum;
        map.put(key,val);
        
        // 处理前缀信息
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i)-'a';
            if (cur.son[index]==null){
                cur.son[index] = new TrieNode();
                cur.son[index].sum = handleNum;
                cur = cur.son[index];
                continue;
            }
            
            cur.son[index].sum += handleNum;
            cur = cur.son[index];
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            // 不存在前缀
            if (cur.son[index]==null){
                return 0;
            }

            cur = cur.son[index];
        }
        return cur.sum;
    }

    // 字典树节点，保存的sum为当前字符代表key前缀的和
    class TrieNode {
        public TrieNode[] son = new TrieNode[26];
        public int sum;
    }

}

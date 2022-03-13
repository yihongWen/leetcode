package zyj.yihong.leetcode.simple.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 面试题50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqCharM50 {

    /**
     * map+队列
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        Map<Character,Integer> charNumMap = new HashMap<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charNumMap.containsKey(c)){
                charNumMap.put(c,1);
                queue.add(c);
            }else {
                charNumMap.put(c,-1);
                while (!queue.isEmpty() && charNumMap.get(queue.peek())==-1){
                    queue.poll();
                }
            }
        }

        return queue.size()==0?' ':queue.peek();
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = firstUniqChar(s);
        System.out.println(c);
    }
}

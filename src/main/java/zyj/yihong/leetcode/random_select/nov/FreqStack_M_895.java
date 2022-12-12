package zyj.yihong.leetcode.random_select.nov;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 895. 最大频率栈
public class FreqStack_M_895 {
    int maxFreq = 0;
    Map<Integer,Integer> numFreqMap = new HashMap<>();
    Map<Integer, Stack<Integer>> freqStackMap = new HashMap<>();
    public FreqStack_M_895() {

    }

    public void push(int val) {
        numFreqMap.put(val, numFreqMap.getOrDefault(val, 0)+1);
        int valFreq = numFreqMap.get(val);
        freqStackMap.putIfAbsent(valFreq,new Stack<>());
        freqStackMap.get(valFreq).push(val);
        maxFreq = Math.max(maxFreq,valFreq);
    }

    public int pop() {
        Integer ans = freqStackMap.get(maxFreq).pop();
        numFreqMap.put(ans,numFreqMap.get(ans)-1);
        if (freqStackMap.get(maxFreq).size()==0){
            maxFreq--;
        }
        return ans;
    }
}

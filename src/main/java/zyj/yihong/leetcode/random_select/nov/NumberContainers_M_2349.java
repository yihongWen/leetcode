package zyj.yihong.leetcode.random_select.nov;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

// 2349. 设计数字容器系统
public class NumberContainers_M_2349 {

    Map<Integer, Integer> indexNumMap = new HashMap<>();
    Map<Integer, TreeSet<Integer>> numIndexTreeSetMap = new HashMap<>();

    public NumberContainers_M_2349() {

    }

    public void change(int index, int number) {
        Integer num = indexNumMap.get(index);
        if (Objects.equals(num,number)){
            return;
        }
        TreeSet<Integer> treeSet = numIndexTreeSetMap.get(number);
        if (treeSet == null) {
            treeSet = new TreeSet<>();
        }

        indexNumMap.put(index, number);
        treeSet.add(index);
        numIndexTreeSetMap.put(number, treeSet);
        if (num == null) {
            return;
        }

        numIndexTreeSetMap.get(num).remove(index);
    }

    public int find(int number) {
        TreeSet<Integer> treeSet = numIndexTreeSetMap.get(number);
        if (treeSet == null || treeSet.size() == 0) {
            return -1;
        }
        return treeSet.first();
    }

    public static void main(String[] args) {
//        ["NumberContainers","change","change","find","change","find"]
//[[],[1,10],[1,10],[10],[1,20],[10]]
        NumberContainers_M_2349 numberContainers_m_2349 = new NumberContainers_M_2349();
        numberContainers_m_2349.change(1,10);
        numberContainers_m_2349.change(1,10);
        int i = numberContainers_m_2349.find(10);
        numberContainers_m_2349.change(1,20);
        int i1 = numberContainers_m_2349.find(10);
        System.out.println(i);
        System.out.println(i1);


    }

}


package zyj.yihong.leetcode.random_select.aug;

import java.util.Comparator;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

// 1470. 重新排列数组
public class Shuffle_S_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[i+ n];
        }
        return ans;
    }

    public static void main(String[] args) {
        // TreeMap的使用
        TreeMap<TreeMapKeyNode,String> map =  new TreeMap<>(Comparator.comparingLong(o -> o.time));
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(20);
            TreeMapKeyNode treeMapKeyNode = new TreeMapKeyNode("key_" + i1, i1);
            map.putIfAbsent(treeMapKeyNode,"value_"+i1);
        }

        SortedMap<TreeMapKeyNode, String> treeMapKeyNodeStringSortedMap = map.subMap(new TreeMapKeyNode("a", 0), new TreeMapKeyNode("b", 10));
        treeMapKeyNodeStringSortedMap.forEach((k,v)->{
            System.out.println("k_"+k.key+"_"+k.time+": "+v);
        });

    }


    static class TreeMapKeyNode {
        public String key;
        public long time;

        public TreeMapKeyNode(String key, long time) {
            this.key = key;
            this.time = time;
        }
    }

}

package zyj.yihong.leetcode.random_select.seg;

import java.util.*;

// 面试题 17.09. 第 k 个数
public class GetKthMagicNumber_M_M1709 {
    public static int getKthMagicNumber(int k) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        queue.add(1);
        int curNum = 1;
        for (int i = 1; i <= k; i++) {
            curNum = queue.poll();

            int n1 = curNum * 3;
            int n2 = curNum * 5;
            int n3 = curNum * 7;
            if (!set.contains(n1)&&curNum<=715827882) {
                set.add(n1);
                queue.add(n1);
            }
            if (!set.contains(n2)&&curNum<=429496729) {
                set.add(n2);
                queue.add(n2);
            }
            if (!set.contains(n3)&&curNum<=306783378) {
                set.add(n3);
                queue.add(n3);
            }
        }
        return curNum;
    }

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(643));
    }
}

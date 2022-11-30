package zyj.yihong.leetcode.random_select.nov;

import java.util.HashSet;
import java.util.Set;

// LCP 11. 期望个数统计
public class ExpectNumber_S_LCP11 {
    public int expectNumber(int[] scores) {
        Set<Integer> set = new HashSet<>();
        for (int score : scores) {
            set.add(score);
        }
        return set.size();
    }
}

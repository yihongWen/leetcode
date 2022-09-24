package zyj.yihong.leetcode.random_select.seg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Flip_M_519 {
    private int m;
    private int n;
    private int curTotal;
    private Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public Flip_M_519(int m, int n) {
        solution(m, n);
    }

    public void solution(int m, int n) {
        this.m = m;
        this.n = n;
        curTotal = m * n;
    }

    public int[] flip() {
        int[] ans = new int[2];
        int selectIndex = random.nextInt(curTotal);
        curTotal--;

        // 找到当前所对应的映射
        Integer realIndex = map.getOrDefault(selectIndex, selectIndex);
        ans[0] = realIndex / n;
        ans[1] = realIndex % n;

        // 将当前的点标记新的映射
        map.put(selectIndex,map.getOrDefault(curTotal,curTotal));
        return ans;

    }

    public void reset() {
        curTotal = m * n;
        map.clear();
    }

}

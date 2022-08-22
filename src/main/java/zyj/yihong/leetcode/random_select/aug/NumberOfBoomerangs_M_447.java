package zyj.yihong.leetcode.random_select.aug;

import java.util.HashMap;
import java.util.Map;

// 447. 回旋镖的数量
public class NumberOfBoomerangs_M_447 {
    public int numberOfBoomerangs(int[][] points) {
        // 枚举（使用map减少一个数据集的复杂度）
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] pointA : points) {
            map.clear();
            for (int[] pointB : points) {
                int x = pointA[0]-pointB[0];
                int y = pointA[1]-pointB[1];
                Integer v = (int) (Math.pow(x, 2) + Math.pow(y, 2));
                map.put(v,map.getOrDefault(v,0)+1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer v = entry.getValue();
                ans += v * (v - 1);
            }
        }
        return ans;
    }
}

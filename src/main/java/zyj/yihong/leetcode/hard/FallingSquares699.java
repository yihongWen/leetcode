package zyj.yihong.leetcode.hard;

import java.util.*;

/**
 * 699. 掉落的方块
 */
public class FallingSquares699 {
    public static List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> ret = new ArrayList<>();
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 0); // 初始时从 0 开始的所有点的堆叠高度都是 0
        for (int i = 0; i < n; i++) {
            int size = positions[i][1];
            int left = positions[i][0];
            int right = positions[i][0] + positions[i][1] - 1;

            int rHeight = heightMap.floorEntry(right + 1).getValue(); // 记录right + 1的高度

            // 该方块的堆叠高度
            int height = 0;
            Map.Entry<Integer, Integer> lower;
            while((lower = heightMap.floorEntry(right)) != null) {
                height = Math.max(height, lower.getValue());
                if(lower.getKey() >= left) {
                    //删除[left, right]范围内所有的key
                    heightMap.remove(lower.getKey());
                    if(lower.getKey() <= left) {
                        //高度开始位置小于等于left，[left, right]的最大高度更新完毕
                        break;
                    }
                } else {
                    break;
                }
            }
            height += size;
            heightMap.put(left, height); // 更新 left 的变化

            if (!heightMap.containsKey(right + 1)) { // 如果 right + 1 不在 heightMap 中，更新 right + 1 的变化
                heightMap.put(right + 1, rHeight);
            }

            ret.add(i > 0 ? Math.max(ret.get(i - 1), height) : height);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,1},{2,9},{13,2}};
        List<Integer> integers = fallingSquares(arr);
        System.out.println(integers);
    }
}

package zyj.yihong.leetcode.random_select;

//你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
//
//你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
//
//给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/brick-wall
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.*;

public class LeastBricks_M_554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map =  new HashMap<>();

        for (List<Integer> curLevelWall : wall) {
            int curLength = 0;
            for (int i = 0; i < curLevelWall.size()-1; i++) {
                curLength+=curLevelWall.get(i);
                map.put(curLength,map.getOrDefault(curLength,0)+1);
            }
        }

        int maxGap = 0;
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            maxGap = Math.max(mapEntry.getValue(),maxGap);
        }

        return wall.size()-maxGap;
    }

    public static void main(String[] args) {
//        [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        LeastBricks_M_554 leastBricks_m_554 = new LeastBricks_M_554();
        int i = leastBricks_m_554.leastBricks(wall);
        System.out.println(i);


    }
}

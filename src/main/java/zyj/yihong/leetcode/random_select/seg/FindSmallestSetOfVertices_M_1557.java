package zyj.yihong.leetcode.random_select.seg;

import java.util.ArrayList;
import java.util.List;

// 1557. 可以到达所有点的最少点数目
public class FindSmallestSetOfVertices_M_1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // 只要是入度为0的节点即可，题目保证存在答案
        List<Integer> ans = new ArrayList<>();
        boolean[] flag = new boolean[n];
        for (List<Integer> edge : edges) {
            flag[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!flag[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}

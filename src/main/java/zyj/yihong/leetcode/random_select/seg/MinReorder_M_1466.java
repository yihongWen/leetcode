package zyj.yihong.leetcode.random_select.seg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1466. 重新规划路线
public class MinReorder_M_1466 {
    public static int minReorder(int n, int[][] connections) {
        int ans = 0;

        boolean[] flag = new boolean[n];

        // 保存每个节点连接信息所在connections的index
        List<List<Integer>> connectInfoList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connectInfoList.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            connectInfoList.get(connections[i][0]).add(i);
            connectInfoList.get(connections[i][1]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size() != 0) {
            Integer node = queue.poll();
            flag[node] = true;
            List<Integer> nodeConnectionInfo = connectInfoList.get(node);
            for (Integer index : nodeConnectionInfo) {
                int[] con = connections[index];
                int start = con[0];
                int end = con[1];
                if (flag[start] && flag[end]) {
                    continue;
                }
                flag[start] = true;
                flag[end] = true;
                if (start == node) {
                    ans++;
                    queue.add(end);
                } else {
                    queue.add(start);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int ans = minReorder(6, arr);
        System.out.println(ans);
    }
}

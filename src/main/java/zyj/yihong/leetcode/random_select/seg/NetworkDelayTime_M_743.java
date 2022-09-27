package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 743. 网络延迟时间
public class NetworkDelayTime_M_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 问题转化为无负边权的单元最短路径

        // 构图
        int[][] graph = new int[n][n];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            int i = time[0];
            int j = time[1];
            int v = time[2];
            graph[i - 1][j - 1] = v;
        }

        // 初始化数据
        int[] ansArr = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            ansArr[i] = graph[k - 1][i];
        }
        flag[k - 1] = true;
        ansArr[k - 1] = 0;

        // 加点：
        int selectNode = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!flag[j] && (ansArr[j] < min)) {
                    min = ansArr[j];
                    selectNode = j;
                }
            }

            flag[selectNode] = true;

            // 选中节点后，对剩下点集合的影响
            for (int j = 0; j < n; j++) {
                if (min != Integer.MAX_VALUE && graph[selectNode][j]!=Integer.MAX_VALUE && (ansArr[j] == Integer.MAX_VALUE || (ansArr[j] > ansArr[selectNode] + graph[selectNode][j]))) {
                    ansArr[j] = ansArr[selectNode] + graph[selectNode][j];
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < ansArr.length; i++) {
            if (ansArr[i] == Integer.MAX_VALUE ) {
                return -1;
            }
            ans = Math.max(ans,ansArr[i]);
        }
        return ans;

    }

    public static void main(String[] args) {

        int[][] times = {{1, 2, 1},{2,3,2},{1,3,1}};
        int n = 3;
        int k = 2;
        NetworkDelayTime_M_743 networkDelayTime_m_743 = new NetworkDelayTime_M_743();
        int i = networkDelayTime_m_743.networkDelayTime(times, n, k);
        System.out.println(i);
    }
}

package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 847. 访问所有节点的最短路径
public class ShortestPathLength_S_847 {
    public static int shortestPathLength(int[][] graph) {
        // 状态压缩+bfs
        //{state,dis}
        Queue<int[]> queue = new LinkedList<>();
        int[][] disArr = new int[1 << graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            queue.add(new int[]{1 << i, 0, i});
        }

        for (int i = 0; i < disArr.length; i++) {
            Arrays.fill(disArr[i], -1);
        }

        while (queue.size() != 0) {
            int[] curNode = queue.poll();
            int curState = curNode[0];
            int distance = curNode[1];
            int nodeIndex = curNode[2];

            if (curState == (1 << graph.length) - 1) {
                return distance;
            }

            for (int nextCon : graph[nodeIndex]) {
                // 计算下一个连接的状态
                if (disArr[curState | (1 << nextCon)][nextCon] == -1) {
                    disArr[curState | (1 << nextCon)][nextCon] = distance + 1;
                    queue.add(new int[]{curState | (1 << nextCon), distance + 1, nextCon});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] graph = 
        {{1},{0,2,4},{1,3,4},{2},{1,2}};
        int i = shortestPathLength(graph);
        System.out.println(i);

    }
}

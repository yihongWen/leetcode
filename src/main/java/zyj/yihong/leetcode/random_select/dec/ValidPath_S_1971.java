package zyj.yihong.leetcode.random_select.dec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1971. 寻找图中是否存在路径
public class ValidPath_S_1971 {
    private List<Integer>[] graphInfoList;
    private boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 初始化图
        graphInfoList = new List[n];
        for (int i = 0; i < graphInfoList.length; i++) {
            graphInfoList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graphInfoList[edge[0]].add(edge[1]);
            graphInfoList[edge[1]].add(edge[0]);
        }

        visited = new boolean[n];
        return bfs(source,destination);
    }

    private boolean bfs(int source,int destination){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (queue.size()!=0){
            Integer num = queue.poll();
            if (num==destination){
                return true;
            }

            for (Integer next : graphInfoList[num]) {
                if (!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }
        return false;
    }
}

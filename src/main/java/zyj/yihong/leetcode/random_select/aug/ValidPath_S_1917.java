package zyj.yihong.leetcode.random_select.aug;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1971. 寻找图中是否存在路径
public class ValidPath_S_1917 {

    private List<Integer>[] graphDfs;
    boolean[] flagDfs;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 使用bfs
        // 构造图（邻接链表的方式）（双向）
        List<Integer>[] graph = new ArrayList[n];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (graph[a]==null){
                graph[a] = new ArrayList<>();
            }

            if (graph[b]==null){
                graph[b] = new ArrayList<>();
            }

            graph[a].add(b);
            graph[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean[] flag = new boolean[n];

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            flag[poll] = true;
            if (poll==destination){
                return true;
            }

            // 扫描与当前节点相连的节点
            for (Integer node : graph[poll]) {
                if (flag[node]){
                    continue;
                }

                queue.add(node);
            }
        }
        return false;
    }


    public boolean validPath_dfs(int n, int[][] edges, int source, int destination) {
        // 使用bfs
        // 构造图（邻接链表的方式）（双向）
        graphDfs = new ArrayList[n];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (graphDfs[a]==null){
                graphDfs[a] = new ArrayList<>();
            }

            if (graphDfs[b]==null){
                graphDfs[b] = new ArrayList<>();
            }

            graphDfs[a].add(b);
            graphDfs[b].add(a);
        }

        flagDfs = new boolean[n];

        return dfs(source,destination);

    }

    private boolean dfs(int source, int destination){
        if (source==destination){
            return true;
        }
        flagDfs[source] = true;

        for (Integer node : graphDfs[source]) {
            if (flagDfs[node]){
                continue;
            }

            boolean dfs = dfs(node, destination);
            if (dfs){
                return true;
            }
        }
        return false;
    }
}

package zyj.yihong.leetcode.random_select.seg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 1129. 颜色交替的最短路径
public class ShortestAlternatingPaths_M_1129 {
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 构造数据:红色定义为1，绿色定义为2
        int[][] graph = new int[n][n];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] flag = new int[n];
        for (int i = 0; i < redEdges.length; i++) {
            int[] redEdge = redEdges[i];
            graph[redEdge[0]][redEdge[1]] += 1;
        }

        for (int i = 0; i < blueEdges.length; i++) {
            int[] blueEdge = blueEdges[i];
            graph[blueEdge[0]][blueEdge[1]] += 2;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1});
        queue.add(new int[]{0, 2});
        flag[0] = 3;
        int step = 0;
        ans[0] = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int colour = cur[1];

                if (colour==1) {
                    // 当前节点为红色，下一个节点需要为绿色
                    for (int next = 0; next < graph[cur[0]].length; next++) {
                        if (graph[cur[0]][next] == 0) {
                            continue;
                        }
                        if ((flag[next]==1||flag[next]==0)&&(graph[cur[0]][next]==3||graph[cur[0]][next]==2)){
                            if (flag[next]==0 || flag[next]==1) {
                                queue.add(new int[]{next, 2});
                            }

                            flag[next]+=2;
                            if (ans[next]==-1) {
                                ans[next] = step;
                            }
                        }
                    }
                }else if (colour==2){
                    for (int next = 0; next < graph[cur[0]].length; next++) {
                        if (graph[cur[0]][next] == 0) {
                            continue;
                        }
                        if ((flag[next]==2||flag[next]==0) && (graph[cur[0]][next]==3||graph[cur[0]][next]==1)){
                            if (flag[next]==2 || flag[next]==0) {
                                queue.add(new int[]{next, 1});
                            }
                            flag[next]+=1;
                            if (ans[next]==-1) {
                                ans[next] = step;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {


        int n = 6;
        int[][] red_edges =  {{4,1},{3,5},{5,2},{1,4},{4,2},{0,0},{2,0},{1,1}};
        int[][] blue_edges = {{5,5},{5,0},{4,4},{0,3},{1,0}};
//        5
//[[0,1],[1,2],[2,3],[3,4]]
//[[1,2],[2,3],[3,1]]
//        int n = 5;
//        int[][] red_edges = {{0,1},{1,2},{2,3},{3,4}};
//        int[][] blue_edges = {{1,2},{2,3},{3,1}};
        int[] ints = shortestAlternatingPaths(n, red_edges, blue_edges);
        System.out.println(Arrays.toString(ints));

    }
}

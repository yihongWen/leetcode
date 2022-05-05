package zyj.yihong.leetcode.mid.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 417. 太平洋大西洋水流问题
public class PacificAtlantic417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 定义两个二维数组，分别表示（i,j）能否到达大平洋和大西洋
        boolean[][] reachPacific =new  boolean[heights.length][heights[0].length];
        boolean[][] reachAtlantic = new boolean [heights.length][heights[0].length];

        // 两个边界上的岛屿分别可以到达，进行深度优先搜索，看所有的节点是否能够满足到达边界上的点
        for (int i = 0; i < heights.length; i++) {
            dfs(i,0,heights,reachPacific);
            dfs(i,heights[0].length-1,heights,reachAtlantic);
        }

        for (int i = 0; i < heights[0].length; i++) {
            dfs(0,i,heights,reachPacific);
            dfs(heights.length-1,i,heights,reachAtlantic);

        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (reachAtlantic[i][j]&&reachPacific[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private void dfs(int i,int j,int[][]data,boolean[][]reach){
        // 如果该节点曾今来过，已经是true了，那么直接返回
        if (reach[i][j]){
            return;
        }

        // 进入dfs，i,j处于边界值
        reach[i][j] = true;

        // 往4个方向进行dfs
        // 往上
        if (i-1>=0&&data[i][j]<=data[i-1][j]) {
            dfs(i-1, j, data, reach);
        }

        // 往下
        if (i+1<data.length&&data[i][j]<=data[i+1][j]) {
            dfs(i+1, j, data, reach);
        }


        // 往左
        if (j-1>=0&&data[i][j]<=data[i][j-1]) {
            dfs(i, j-1, data, reach);
        }


        // 往右
        if (j+1<data[0].length&&data[i][j]<=data[i][j+1]) {
            dfs(i, j+1, data, reach);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        PacificAtlantic417 pacificAtlantic417 = new PacificAtlantic417();
        List<List<Integer>> lists = pacificAtlantic417.pacificAtlantic(arr);
        lists.forEach(System.out::println);
    }

//    [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
}

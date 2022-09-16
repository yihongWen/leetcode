package zyj.yihong.leetcode.random_select.seg;

// 1615. 最大网络秩
public class MaximalNetworkRank_S_1615 {
    public static int maximalNetworkRank(int n, int[][] roads) {
        // 每次城市链接的度数
        int[] count = new int[n];

        // 保存每个城市的连接信息
        int[][] graph = new int[n][n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            graph[road[0]][road[1]] = 1;
            graph[road[1]][road[0]] = 1;

        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                ans = Math.max(ans,count[i]+count[j]-graph[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        int n = 8;
        int i = maximalNetworkRank(n, roads);
        System.out.println(i);

    }
}

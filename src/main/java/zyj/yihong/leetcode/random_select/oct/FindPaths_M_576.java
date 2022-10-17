package zyj.yihong.leetcode.random_select.oct;

import java.util.Arrays;

public class FindPaths_M_576 {
    private int[][][] cache;
    int mod = (int)1e9+7;
    int[][] direct = {{0,1},{1,0},{-1,0},{0,-1}};
    int m;
    int n;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[m][n][maxMove+1];
        this.m = m;
        this.n = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cache[i][j],-1);
            }
        }
        return dfs(startRow,startColumn,maxMove);
    }


    public int findPathsDp(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        // 初始化dp
        dp[startRow][startColumn][0] = 1;
        int ans = 0;
        for (int k = 0; k < maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    int count = dp[i][j][k];
                    // 表示从起始位置开始
                    if (count>0) {
                        for (int[] d : direct) {
                            int ni = i + d[0];
                            int nj = j + d[1];
                            if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                                // 出界
                                ans+=count;
                                ans%=mod;
                            }else {
                                dp[ni][nj][k+1]+=count;
                                dp[ni][nj][k+1]%=mod;
                            }
                        }
                    }

                }
            }
        }



        return ans;
    }

    public int dfs(int i,int j,int t){
        // 出界返回
        if (i<0 || i>=m || j<0 || j>=n){
            return 1;
        }

        if (t==0){
            return 0;
        }

        if (cache[i][j][t]!=-1){
            return cache[i][j][t];
        }

        int ans = 0;
        for (int[] d : direct) {
            int ni = i+d[0];
            int nj = j+d[1];
            ans+=dfs(ni,nj,t-1);
            ans%=mod;
        }

        cache[i][j][t] = ans;
        return ans;
    }

    public static void main(String[] args) {
        FindPaths_M_576 findPaths_m_576 = new FindPaths_M_576();
        int paths = findPaths_m_576.findPathsDp(2, 2, 2, 0, 0);
        System.out.println(paths);
    }
}

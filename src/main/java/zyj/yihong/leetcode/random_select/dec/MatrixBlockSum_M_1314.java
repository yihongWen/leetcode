package zyj.yihong.leetcode.random_select.dec;

// 1314. 矩阵区域和
public class MatrixBlockSum_M_1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // 二维前缀和
        int[][] preSumArr = new int[mat.length+1][mat[0].length+1];
        for (int i = 1; i <= mat.length ; i++) {
            for (int j = 1; j <= mat[0].length; j++) {
                preSumArr[i][j] = preSumArr[i-1][j]+preSumArr[i][j-1]-preSumArr[i-1][j-1]+mat[i-1][j-1];
            }
        }

        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int x1 = Math.min(i + k,mat.length-1);
                int x2 = Math.max(i-k,0);
                int y1 = Math.min(j + k, mat[0].length - 1);
                int y2 = Math.max(j-k,0);
                ans[i][j] = preSumArr[x1+1][y1+1]-preSumArr[x1+1][y2]-preSumArr[x2][y1+1]+preSumArr[x2][y2];
            }
        }

        return ans;
    }
}

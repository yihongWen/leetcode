package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;

// 566. 重塑矩阵
public class MatrixReshape_S_566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (!(mat.length*mat[0].length==r*c)){
            return mat;
        }
        int[][] reMat = new int[r][c];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int cur = i*mat[0].length + j;
                reMat[cur/c][cur%c] = mat[i][j];
            }
        }
        return reMat;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
        int[][] ans = matrixReshape(arr, 1, 4);
        System.out.println(Arrays.toString(ans));
    }
}

package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 面试题 01.08. 零矩阵
public class SetZeroes_M_M0108 {
    public void setZeroes(int[][] matrix) {
        boolean colZero = false;
        boolean rowZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==0){
                colZero = true;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i]==0){
                rowZero = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }

        for (int j = 1; j < matrix[0].length ; j++) {
            if (matrix[0][j]==0){
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (colZero){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (rowZero){
            Arrays.fill(matrix[0],0);
        }

    }
}

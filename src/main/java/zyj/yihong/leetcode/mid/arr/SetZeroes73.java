package zyj.yihong.leetcode.mid.arr;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class SetZeroes73 {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int i1 = 0; i1 < col.length; i1++) {
                if (row[i]&col[i1]){
                    setIndex(matrix,i,i1);
                }
            }
        }
    }

    private void setIndex(int[][] matrix,int i,int j){
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k]=0;
        }

        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }

}

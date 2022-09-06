package zyj.yihong.leetcode.random_select.seg;

public class IsToeplitzMatrix_S_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int indexI = i;
            int indexJ = 0;
            int v = matrix[indexI][indexJ];
            while (indexI>=0&&indexI<matrix.length&&indexJ>=0&&indexJ<matrix[0].length){
                if (matrix[indexI][indexJ]!=v){
                    return false;
                }
                indexI++;
                indexJ++;
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            int indexI = 0;
            int indexJ = j;
            int v = matrix[indexI][indexJ];
            while (indexI>=0&&indexI<matrix.length&&indexJ>=0&&indexJ<matrix[0].length){
                if (matrix[indexI][indexJ]!=v){
                    return false;
                }
                indexI++;
                indexJ++;
            }
        }

        return true;
    }
}

package zyj.yihong.leetcode.mid.arr;

/**
 * 剑指 Offer 04. 二维数组中的查找
 */
public class FindNumberIn2DArray_J04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while (i<matrix.length&&j>=0){
            if (matrix[i][j]==target){
                return true;
            }else if (matrix[i][j]<target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       int[][] arr =  {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean numberIn2DArray = findNumberIn2DArray(arr, 5);
        System.out.println(numberIn2DArray);
    }
}

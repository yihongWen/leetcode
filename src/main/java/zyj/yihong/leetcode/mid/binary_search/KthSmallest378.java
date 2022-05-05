package zyj.yihong.leetcode.mid.binary_search;

/**
 * 378. 有序矩阵中第 K 小的元素
 *
 */
public class KthSmallest378 {
    public int kthSmallest(int[][] matrix, int k) {
        // 使用二分查找
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix.length-1];
        while (left<right){
            int mid = left+(right-left)/2;
            int count = binarySearch(matrix, mid);
            if (count<k){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[][] matrix,int num){
        int count = 0;
        int i = matrix.length-1;
        int j = 0;
        while (i>=0 && j<matrix.length){
            if (num>=matrix[i][j]){
                count = count+i+1;
                j++;
            }else {
                i--;
            }
        }

        return count;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }


    public static void main(String[] args) {
        int sum = getSum(5, 6);


    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

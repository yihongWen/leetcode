package zyj.yihong.leetcode.random_select.seg;

// 1582. 二进制矩阵中的特殊位置
public class NumSpecial_S_1582 {
    public static int numSpecial(int[][] mat) {
       int[] row = new int[mat.length];
       int[] col = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==1&&col[j]==1&&row[i]==1){
                    ans++;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0}, {1, 1, 0}, {0, 0, 1}};
        int numSpecial = numSpecial(arr);
        System.out.println(numSpecial);
    }
}

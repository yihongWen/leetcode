package zyj.yihong.leetcode.mid.arr;

/**
 * 498. 对角线遍历
 */
public class FindDiagonalOrder498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m*n];
        int ansIndex = 0;

        // 对角线的个数:
        int count = m+n-1;
        for (int i = 0; i < count; i++) {
            // 根据奇偶性区分方向：偶数（从左下往右上）
            if ((i&1)==0){
                // 判断是否超过了最大的线
                int curPointX = i<m?i:(m-1);
                int curPointY = i<m?0:(i-m+1);

                // 循环处理每个线上的数据
                while(curPointX>=0&&curPointY<n){
                    ans[ansIndex] = mat[curPointX][curPointY];
                    ansIndex++;
                    curPointX--;
                    curPointY++;
                }
                continue;
            }

            // 判断是否超过了最大的线
            int curPointX = i<n?0:(i-n+1);
            int curPointY = i<n?i:(n-1);

            // 循环处理每个线上的数据
            while(curPointX<m&&curPointY>=0){
                ans[ansIndex] = mat[curPointX][curPointY];
                ansIndex++;
                curPointX++;
                curPointY--;
            }
        }
       return ans;
    }
}

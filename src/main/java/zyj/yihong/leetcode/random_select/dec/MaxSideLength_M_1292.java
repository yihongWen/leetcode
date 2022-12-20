package zyj.yihong.leetcode.random_select.dec;

// 1292. 元素和小于等于阈值的正方形的最大边长
public class MaxSideLength_M_1292 {
    public int maxSideLength(int[][] mat, int threshold) {

        // 计算二维前缀和
        int[][] preSum = new int[mat.length+1][mat[0].length+1];
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                preSum[i][j] = preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+mat[i-1][j-1];
            }
        }

        // 枚举边长
        int ans = 0;
        int left = 1;
        int right = Math.min(mat.length,mat[0].length);
        while (left<=right){
            int mid = left+(right-left+1)/2;
            boolean flag = false;
            for (int i = 0; i+mid<= mat.length; i++) {
                for (int j = 0; j+mid <= mat[0].length; j++) {
                    int v = preSum[i + mid][j + mid] - preSum[i][j + mid] - preSum[i + mid][j] + preSum[i][j];
                    if (v<=threshold) {
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }
            if (flag){
                left = mid+1;
                ans = mid;
            }else {
                right = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}};
        MaxSideLength_M_1292 maxSideLength_m_1292 = new MaxSideLength_M_1292();
        int ans = maxSideLength_m_1292.maxSideLength(mat, 1);
        System.out.println(ans);

    }
}

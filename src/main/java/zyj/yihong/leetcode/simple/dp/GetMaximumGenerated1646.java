package zyj.yihong.leetcode.simple.dp;

/**
 * 1646. 获取生成数组中的最大值
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetMaximumGenerated1646 {
    public int getMaximumGenerated(int n) {
        if (n<2){
            return n;
        }
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;

        for (int i = 2; i <= n ; i++) {
            ans[i] = ans[i/2]+(i%2)*ans[i/2+1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
           if (ans[i]>max){
               max =ans[i];
           }
        }

        return max;
    }
}

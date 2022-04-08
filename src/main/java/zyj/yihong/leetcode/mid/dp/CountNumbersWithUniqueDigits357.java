package zyj.yihong.leetcode.mid.dp;

/**
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 */
public class CountNumbersWithUniqueDigits357 {

    public int countNumbersWithUniqueDigits(int n) {
        // 根据位数进行dp
        int sum = 0;
        int state = 0;

        for (int i = 2; i <=n ; i++) {
            // 当前的重复的个数：
            int preRepeat = state * 10;
            int preAll =  (int)(9 * Math.pow(10, i - 2));
            state = preRepeat+(preAll-state)*(i-1);
            sum+= state;
        }


        return (int)Math.pow(10,n)-sum;
    }
}

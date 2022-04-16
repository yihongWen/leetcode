package zyj.yihong.leetcode.hard;

/**
 * 479. 最大回文数乘积
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 */
public class LargestPalindrome497 {
    // 使用枚举，构造出所有的回文数，判断该数能否由两个n位的整数乘积所组成
    public static int largestPalindrome(int n) {
        if (n==1){
            return 9;
        }

        int max = (int)Math.pow(10,n)-1;
        for (int i = max; i >=0 ; i--) {
            // 构造回文数
            long p = i;
            int curT = i;
            while (curT>0){
                p = p*10+curT%10;
                curT = curT/10;
            }

            // 计算是否能够由两个n位的乘数构造
            for (long j = max; j*j >= p; j--) {
                if (p%j==0){
                    return(int)(p%1337);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = largestPalindrome(5);
        System.out.println(i);
    }
}

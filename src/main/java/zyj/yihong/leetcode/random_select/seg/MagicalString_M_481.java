package zyj.yihong.leetcode.random_select.seg;

// 481. 神奇字符串
public class MagicalString_M_481 {
    public static int magicalString(int n) {
        if (n<=3){
            return 1;
        }

        // 初始化
        int ans = 1;
        int[] magicalArr = new int[n];
        magicalArr[0] =1;
        magicalArr[1] =2;
        magicalArr[2] =2;
        int fastIndex = 3;
        int slowIndex = 2;
        int nextNum = 1;
        while (fastIndex<n){
            int nextSize = magicalArr[slowIndex];
            for (int i = 0; i < nextSize && fastIndex < n; i++) {
                magicalArr[fastIndex] = nextNum;
                ans+=nextNum&1;
                fastIndex++;
            }
            nextNum = nextNum^3;
            slowIndex++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = magicalString(6);
        System.out.println(i);
    }
}

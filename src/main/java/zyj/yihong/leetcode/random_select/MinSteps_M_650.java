package zyj.yihong.leetcode.random_select;

// 650. 只有两个键的键盘
public class MinSteps_M_650 {
    public static int minSteps(int n) {
        // dp的思路：
        int ans = 0;
        for (int i = 2; i*i <= n; i++) {
            while (n%i==0){
                ans+=i;
                n = n/i;
            }
        }

        // 如果剩下的不是1，则需要一个个迭代到当前n的个数
        if (n!=1){
            ans+=n;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = minSteps(12);
        System.out.println(i);
    }
}

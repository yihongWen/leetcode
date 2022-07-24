package zyj.yihong.leetcode.random_select;

public class LastRemaining_M_390 {
    public int lastRemaining(int n) {
        // 规律、递归
        if (n==1){
            return 1;
        }
        return 2*(n/2+1-lastRemaining(n/2));
    }


    public int lastRemaining2(int n) {
        // 使用等差数列的方式，每当执行一次，步长*2，序列/2
        // 每次执行计算出当前最前的数字
        int ans = 1;
        int step =1;
        int curSize = n;
        boolean odd = true;
        while (curSize>1){
            ans= ans+step;
            if (!odd&&(curSize&1)==0){
                ans-=step;
            }

            curSize = curSize>>1;
            step = step<<1;
            odd = !odd;
        }

        return ans;
    }
}

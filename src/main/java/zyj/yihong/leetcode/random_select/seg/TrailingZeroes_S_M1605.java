package zyj.yihong.leetcode.random_select.seg;


// 面试题 16.05. 阶乘尾数
public class TrailingZeroes_S_M1605 {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n>=5){
            ans+=n/5;
            n=n/5;
        }
        return ans;
    }
}

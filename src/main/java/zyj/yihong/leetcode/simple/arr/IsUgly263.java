package zyj.yihong.leetcode.simple.arr;

public class IsUgly263 {
    public boolean isUgly(int n) {
        int[] factorUglyArr = {2,3,5};
        if (n<=0){
            return false;
        }
        for (int factor : factorUglyArr) {
            while (n%factor==0){
                n=n/factor;
            }
        }
        return n==1;
    }
}

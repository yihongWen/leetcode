package zyj.yihong.leetcode.simple.arr;

/**
 * 326. 3 的幂
 */
public class IsPowerOfThree326 {
    public boolean isPowerOfThree(int n) {
        while (n!=0&&n%3==0){
            n=n/3;
        }
        return n==1;
    }
}

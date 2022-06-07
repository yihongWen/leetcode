package zyj.yihong.leetcode.simple.binary_search;

/**
 * 69. x 的平方根
 */
public class MySqrt69 {
    public static int mySqrt(int x) {
        // 特殊处理
        if (x<2){
            return x;
        }

        int ans = 0;
        int left = 1;
        int right = x/2;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (((long) mid *mid)<=x){
                ans = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = mySqrt(2);
        System.out.println(i);
    }
}

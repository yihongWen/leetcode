package zyj.yihong.leetcode.simple.binary_search;

public class ArrangeCoins441 {
    public static int arrangeCoins(int n) {
        // 特殊情况
        if (n<=2){
            return 1;
        }

        int left = 1;
        int right = (n>>1)+1;
        long doubleN = n* 2L;
        while (left<right){
            int mid = left+((right-left+1)>>1);
            long count = ((long) mid * mid) + mid;
            if (doubleN>count){
                left = mid;
            }else if (doubleN<count){
                right = mid-1;
            }else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int i = arrangeCoins(2147483647);
        System.out.println(i);
    }
}

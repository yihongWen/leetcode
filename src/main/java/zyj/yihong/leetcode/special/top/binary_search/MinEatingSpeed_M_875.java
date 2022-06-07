package zyj.yihong.leetcode.special.top.binary_search;

/**
 * 875. 爱吃香蕉的珂珂
 */
public class MinEatingSpeed_M_875 {
    public static int minEatingSpeed(int[] piles, int h) {
        // 二分查找：确定left、right(max(piles))的取值
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(pile,right);
        }

        while (left<right){
            int mid = left+((right-left)>>1);
            int curAns = 0;
            for (int pile : piles) {
                curAns = curAns+(pile/mid)+(pile%mid==0?0:1);
            }

            if (curAns<=h){
                right = mid;
            }else {
                left = mid+1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        int i = minEatingSpeed(piles, h);
        System.out.println(i);

    }
}

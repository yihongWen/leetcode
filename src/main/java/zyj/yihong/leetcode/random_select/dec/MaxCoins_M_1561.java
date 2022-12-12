package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;

// 1561. 你可以获得的最大硬币数目
public class MaxCoins_M_1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = 0;
        int j = piles.length-2;
        int ans = 0;
        while (i<j){
            ans+=piles[j];
            j=j-2;
            i++;
        }
        return ans;
    }
}

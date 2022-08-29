package zyj.yihong.leetcode.random_select.aug;

import java.lang.reflect.Array;
import java.util.Arrays;

// 575. 分糖果
public class DistributeCandies_S_575 {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int count = candyType.length>>1;
        int ans = 1;
        int lateEat = candyType[0];
        for (int i = 1; i < candyType.length&&ans<count; i++) {
            if (lateEat==candyType[i]){
                continue;
            }
            ans++;
            lateEat = candyType[i];
        }
        return ans;

    }
}

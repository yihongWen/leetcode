package zyj.yihong.leetcode.mid.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        // 计算一共有多少个子集
        int count = 1<< nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> curAns = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i>>j)&1)==1){
                    curAns.add(nums[j]);
                }
            }
            ans.add(curAns);
        }
        return ans;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int count = 1<< nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < count; i++) {
            List<Integer> curAns = new ArrayList<>();
            boolean repeat = false;
            for (int j = 0; j < nums.length; j++) {
                if (((i>>j)&1)==1) {
                    if (j > 0 && (((i >> j - 1) & 1) == 0 && nums[j] == nums[j - 1])) {
                        repeat = true;
                        break;
                    }
                    curAns.add(nums[j]);
                }
            }
            if (!repeat) {
                ans.add(curAns);
            }
        }
        return ans;
    }
}

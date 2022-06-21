package zyj.yihong.leetcode.special.top.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * 可以归结为选和不选问题，选和不选对应就是二进制，所以可以使用二进制枚举
 *  或者二叉树路径的形式进行枚举：1 <= nums.length <= 15
 */
public class FindSubsequences_M_419 {

    private List<Integer> curAns = new ArrayList<>();
    private Set<List<Integer>> ans = new HashSet<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        // 使用二进制枚举的方式
        Set<List<Integer>> ans = new HashSet<>();
        int length = nums.length;
        int count = (1<<length)-1;
        for (int i = 1; i <= count ; i++) {
            int curMax = Integer.MIN_VALUE;
            List<Integer> curAns = new ArrayList<>();
            int mark = 1;
            for (int j = 0; j < nums.length; j++) {
                if ((mark&i)!=0&&curMax<=nums[j]){
                    curAns.add(nums[j]);
                    curMax = nums[j];
                }
                mark=mark<<1;
            }
            if (curAns.size()>=2){
                ans.add(curAns);
            }
        }
        return new ArrayList<>(ans);
    }


    public List<List<Integer>> findSubsequencesByBackTrack(int[] nums) {
        backtrack(nums,0,Integer.MIN_VALUE);
        return new ArrayList<>(ans);
    }

    private void backtrack(int[] nums,int index,int curMax){
        if (index>=nums.length){
            if (curAns.size()>=2) {
                ans.add(new ArrayList<>(curAns));
            }
            return;
        }

        // 选择当前这个数or不选择
        if (nums[index]>=curMax){
            curAns.add(nums[index]);
            backtrack(nums,index+1,nums[index]);
            curAns.remove(curAns.size()-1);
        }
        backtrack(nums,index+1,curMax);
    }

    public static void main(String[] args) {
        int[] arr = {4,6,7,7};
//        List<List<Integer>> subsequences = findSubsequences(arr);
//        System.out.println(subsequences);

        FindSubsequences_M_419 findSubsequences_m_419 = new FindSubsequences_M_419();
        List<List<Integer>> subsequencesByBackTrack = findSubsequences_m_419.findSubsequencesByBackTrack(arr);
        System.out.println(subsequencesByBackTrack);
    }
}

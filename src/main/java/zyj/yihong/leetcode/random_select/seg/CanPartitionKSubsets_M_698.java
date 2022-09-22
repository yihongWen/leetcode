package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 698. 划分为k个相等的子集
public class CanPartitionKSubsets_M_698 {
    boolean[] flag;
    int average;
    int[] originNums;
    public boolean canPartitionKSubsets(int[] nums, int k) {

        // 初始化、计算均值、以及能否均摊的特殊情况
        originNums = nums;
        flag = new boolean[1<<nums.length];
        for (int i = 0; i < nums.length; i++) {
            average+=nums[i];
        }
        if (average%k!=0){
            return false;
        }
        average = average/k;

        Arrays.sort(nums);
        if (nums[nums.length-1]>average){
            return false;
        }

        Arrays.fill(flag,true);
        return dfs((1<< nums.length)-1,0);

    }


    // 搜索：state当前的选择状态，curSum当前的累加值
    private boolean dfs(int state,int curSum){
        // 边界条件，全部选择返回
        if (state==0){
            return true;
        }

        // 当前状态是否使用过
        if (!flag[state]){
            return flag[state];
        }

        flag[state] = false;

        // 遍历搜索
        for (int i = 0; i < originNums.length; i++) {
            // 选择当前节点判断是否符合
            if (originNums[i] + curSum > average) {
                break;
            }
            if (((state>>i)&1)!=0){
                if (dfs(state^(1<<i),(originNums[i]+curSum)%average)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CanPartitionKSubsets_M_698 canPartitionKSubsets_m_698 = new CanPartitionKSubsets_M_698();
        int[] arr = new int[]{4,3,2,3,5,2,1};
        int k = 4;
        boolean b = canPartitionKSubsets_m_698.canPartitionKSubsets(arr, 4);
        System.out.println(b);
    }
}

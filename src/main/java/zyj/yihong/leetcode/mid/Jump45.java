package zyj.yihong.leetcode.mid;

/**
 * 跳跃游戏2
 * @author yihong
 */
public class Jump45 {

    /**
     * 反向处理:
     * @param nums 给定数组--非空(且一定满足能够跳跃重点)
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        int curEndIndex = nums.length-1;

        while(curEndIndex>0){
            for (int i = 0; i < curEndIndex; i++) {
                if (nums[i]+i>=curEndIndex){
                    curEndIndex = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }


    /**
     * 方式2：正向处理
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int step = 0;
        // 遍历到当前能达到的最大索引下标
        int curMaxArriveIndex = 0;
        // 前一次处理最大的下标
        int preEnd = 0;

        for (int i = 0; i < nums.length-1; i++) {
            curMaxArriveIndex = Math.max(curMaxArriveIndex,i+nums[i]);
            if (preEnd==i){
                preEnd = curMaxArriveIndex;
                step++;
            }
        }
        return step;
    }
}

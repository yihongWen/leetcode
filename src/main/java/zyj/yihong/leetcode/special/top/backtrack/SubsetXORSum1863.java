package zyj.yihong.leetcode.special.top.backtrack;

/**
 * 1863. 找出所有子集的异或总和再求和
 * nums.length<12
 */
public class SubsetXORSum1863 {

    private static int ans = 0;
    public static int subsetXORSum(int[] nums) {
        // 使用二进制枚举，本质就是回溯、深度遍历的一种方式
        int ans = 0;
        int count = (1<<nums.length)-1;
        for (int i = 0; i <= count; i++) {
            int curAns = 0;
            int mark = 1;
            for (int j = 0; j < nums.length; j++) {
                if ((i&mark)!=0){
                    curAns = curAns^nums[j];
                }
                mark = mark<<1;
            }
            ans+=curAns;
        }
        return ans;
    }



    public static int subsetXORSumByBackTrack(int[] nums) {
        backTrack(nums,0,0);
        return ans;
    }

    public static void backTrack(int[] nums,int index,int curAns) {
        if (index>=nums.length){
            // 处理结果
            ans+=curAns;
            return;
        }
        backTrack(nums,index+1,curAns);
        backTrack(nums,index+1,curAns^nums[index]);
    }
    public static void main(String[] args) {
        int[] arr = {1,3};
        int i = subsetXORSumByBackTrack(arr);
        System.out.println(i);
    }
}

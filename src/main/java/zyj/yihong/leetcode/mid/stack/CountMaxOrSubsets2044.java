package zyj.yihong.leetcode.mid.stack;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * <p>
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * <p>
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountMaxOrSubsets2044 {

    private int result = 0;
    private int maxValue = Integer.MIN_VALUE;

    /**
     * 使用位运算，遍历每一个结果
     *
     * @param nums
     * @return
     */
    public int countMaxOrSubsets(int[] nums) {
        // nums中的每一位都可以选或者不选，所以一共用2的n次方中
        int length = nums.length;
        int count = 1 << length;

        int result = 0;
        int maxValue = Integer.MIN_VALUE;
        // 每次循环代表一种结果
        for (int i = 0; i < count; i++) {
            int curValue = 0;
            for (int j = 0; j < nums.length; j++) {
                // 判断当前的j是否要选择
                if (((i >> j) & 1) == 1) {
                    curValue = curValue | nums[j];
                }
            }

            if (curValue > maxValue) {
                maxValue = curValue;
                result = 1;
            } else if (curValue == maxValue) {
                result++;
            }
        }

        return result;
    }

    public int countMaxOrSubsets1(int[] nums){
        dfs(nums,0,0);
        return result;
    }

    public void dfs(int[] nums,int index,int curCalValue){
        // dfs的结束条件
        if (index== nums.length){
            if (curCalValue>maxValue){
                maxValue = curCalValue;
                result = 1;
            }else if (curCalValue==maxValue){
                result++;
            }
            return;
        }
        dfs(nums,index+1,curCalValue|nums[index]);
        dfs(nums,index+1,curCalValue);

    }


    public static void main(String[] args) {
        int[] test = {3,1};
        CountMaxOrSubsets2044 countMaxOrSubsets2044 = new CountMaxOrSubsets2044();
        int i = countMaxOrSubsets2044.countMaxOrSubsets1(test);
        System.out.println(i);
    }
}

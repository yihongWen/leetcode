package zyj.yihong.leetcode.random_select;

/**
 * 565. 数组嵌套
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/array-nesting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayNesting_M_565 {
    public static int arrayNesting(int[] nums) {
        // 找出最大的环的，遍历每一个起点,如果起点在某一个环中
        // 那边处理完该环后，该环的所有点相当于都处理过
        // 所以只需要一次遍历
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int curCount = 0;
            while (nums[i]<nums.length){
                int num = nums[i];
                nums[i] = nums.length;
                i = num;
                curCount++;
            }
            ans = Math.max(curCount,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2,0};
        int nesting = arrayNesting(arr);
        System.out.println(nesting);
    }
}

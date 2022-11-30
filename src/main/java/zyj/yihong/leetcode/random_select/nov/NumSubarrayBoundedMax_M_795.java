package zyj.yihong.leetcode.random_select.nov;

// 795. 区间子数组个数
public class NumSubarrayBoundedMax_M_795 {
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int gtIndex = -1;
        int sectionIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // 如果当前的值超出右边界，那么包含当前值的区间不存在
            if (num > right) {
                gtIndex = i;
                sectionIndex = -1;
                continue;
            }

            // 小于左边界，那么需要判断在i 到gtIndex之间是否存在 处于left-right中的元素（往右）
            if (num < left && sectionIndex != -1) {
                ans += sectionIndex - gtIndex;
                continue;
            }
            if (num>=left) {
                sectionIndex = i;
                ans += sectionIndex - gtIndex;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {16,69,88,85,79,87,37,33,39,34};
        int left = 55;
        int right = 57;
        int count = numSubarrayBoundedMax(arr, left, right);
        System.out.println(count);
    }
}

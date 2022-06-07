package zyj.yihong.leetcode.special.top.binary_search;

/**
 * 540. 有序数组中的单一元素
 */
public class SingleNonDuplicate_M_504 {
    public static int singleNonDuplicate(int[] nums) {
        // 二分法：根据位置的奇偶性进行二分
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = left+((right-left)>>1);

            // 压缩范围
            if ((mid&1)==1&&nums[mid]==nums[mid-1]){
                left = mid+1;
                continue;
            }

            if ((mid&1)==0&&nums[mid]==nums[mid+1]){
                left = mid+1;
                continue;
            }

            if ((mid&1)==1&&nums[mid]!=nums[mid-1]){
                right = mid;
                continue;
            }

            if ((mid&1)==0&&nums[mid]!=nums[mid+1]){
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,6,8,8};
        int duplicate = singleNonDuplicate(arr);
        System.out.println(duplicate);
    }
}

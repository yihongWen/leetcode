package zyj.yihong.leetcode.simple.binary_search;

public class Search81 {
    public static boolean search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return false;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (right-left)/2+left;

            if (nums[mid]==target){
                return true;
            }

            // case1:相等的情况
            if (nums[mid]==nums[left]&&nums[mid]==nums[right]){
                left++;
                right--;
            }else if (nums[mid]<nums[left]){
                if (target<nums[left]&&target>=nums[mid]){
                    left = mid+1;
                }else {
                    right = mid -1;
                }
            }else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,1};
        boolean search = search(arr, 1);
        System.out.println(search);
    }
}

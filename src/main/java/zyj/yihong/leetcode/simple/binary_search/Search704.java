package zyj.yihong.leetcode.simple.binary_search;

public class Search704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (right-left)/2+left;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                right = mid-1;
                continue;
            }
            left = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
    }
}

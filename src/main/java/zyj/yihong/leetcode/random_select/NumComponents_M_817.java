package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.ListNode;

import java.util.Arrays;

// 817. 链表组件
public class NumComponents_M_817 {
    public int numComponents(ListNode head, int[] nums) {
        // 理解题目 nums中的元素是head链表中的子集，找到子集中可以拼接处理的链表段的个数（优先最长）
        Arrays.sort(nums);

        ListNode curNode = head;
        int ans = 0;
        while (curNode!=null){
            if (binarySearch(nums,curNode.val)&&(curNode.next==null|| !binarySearch(nums,curNode.next.val))){
                ans++;
            }
            curNode= curNode.next;
        }

        return ans;
    }

    boolean binarySearch(int[] nums,int num){
        int left = 0;
        int right = nums.length;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (nums[mid]==num){
                return true;
            } else if (nums[mid] < num) {
                left= mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
    }
}

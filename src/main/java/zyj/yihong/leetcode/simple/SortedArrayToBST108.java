package zyj.yihong.leetcode.simple;


/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * @author yihong
 */
public class SortedArrayToBST108 {

    /**
     * 高度平衡、考虑到最优的快速（每次都是当前最中间位置即可）
     * 二分法
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0){
            return null;
        }
        TreeNode handler = handler(nums, 0, nums.length-1);
        return handler;
    }

    public static TreeNode handler(int[] nums,int start,int end){
        if (start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = handler(nums,start,mid-1);
        head.right = handler(nums,mid+1,end);
        return head;
    }

    public static void main(String[] args) {
        int[] test = {-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(test);
        System.out.println(treeNode.toString());

    }



    /**
     * 树节点类
     */
    static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

}

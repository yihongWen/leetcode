package zyj.yihong.leetcode.simple.graph;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 110. 平衡二叉树
 */
public class IsBalanced110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        return Math.abs(leftHeight-rightHeight)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }


    private int calculateHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

}

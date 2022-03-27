package zyj.yihong.leetcode.simple.recursion;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
       return recursion(root,root);
    }

    private boolean recursion(TreeNode node1,TreeNode node2){
        // 如果两者为空，true
        if (node1==null && node2==null){
            return true;
        }

        // 一个为空，一个不是空
        if (node1==null || node2==null){
            return false;
        }

        // 两者都不为空
        if (node1.val!= node2.val){
            return false;
        }

        // 遍历子节点是否对称
        return recursion(node1.left,node2.right) && recursion(node1.right,node2.left);
    }

    public static class TreeNode {
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

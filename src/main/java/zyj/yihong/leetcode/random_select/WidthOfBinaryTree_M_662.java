package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.TreeNode;

public class WidthOfBinaryTree_M_662 {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left==null&&root.right==null){
            return 1;
        }else if (root.left!=null&&root.right!=null){
            return dfs(root.left)+dfs(root.right);
        }else{
            return Math.max(Math.max(dfs(root.left),dfs(root.right)),2);
        }
    }
}

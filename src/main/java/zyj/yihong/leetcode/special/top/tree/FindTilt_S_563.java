package zyj.yihong.leetcode.special.top.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 563. 二叉树的坡度
 */
public class FindTilt_S_563 {
    private int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        // 边界条件
        if (root==null){
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        ans+= Math.abs(leftSum-rightSum);
        return leftSum+rightSum+root.val;

    }
}

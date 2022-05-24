package zyj.yihong.leetcode.simple.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class IsUnivalTree965 {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }


        if (root.left != null) {
            boolean leftDfs = dfs(root.left);
            if (!(leftDfs && root.val == root.left.val)) {
                return false;
            }
        }

        if (root.right!=null) {
            boolean rightDfs = dfs(root.right);
            if (!(rightDfs && root.val == root.right.val)) {
                return false;
            }
        }

        return true;
    }
}

package zyj.yihong.leetcode.special.top.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 */
public class SearchBST_S_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        // 迭代的方式
        TreeNode curNode = root;
        while (curNode!=null&&curNode.val!=val){
            if (curNode.val<val){
                curNode = curNode.right;
                continue;
            }

            curNode = curNode.left;
        }
        return curNode;
    }


    public TreeNode dfs(TreeNode root, int val) {
        // 边界条件
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return dfs(root.right, val);
        }
        return dfs(root.left, val);

    }
}

package zyj.yihong.leetcode.random_select.seg;

import zyj.yihong.leetcode.utils.TreeNode;

// 814. 二叉树剪枝
public class PruneTree_M_814 {
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        if (root.left==null&&root.right==null&&root.val==0){
            return null;
        }
        return root;
    }

    private boolean dfs(TreeNode root) {

        if (root==null){
            return false;
        }

        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (!l){
            root.left =null;
        }

        if (!r){
            root.right = null;
        }

        if (r || l || root.val==1){
            return true;
        }

        return false;
    }
}

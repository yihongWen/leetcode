package zyj.yihong.leetcode.random_select.dec;

import zyj.yihong.leetcode.utils.TreeNode;

// 1325. 删除给定值的叶子节点
public class RemoveLeafNodes_M_1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root,target);
    }

    private TreeNode dfs(TreeNode root,int target){
        if (root==null){
            return null;
        }
        root.left = dfs(root.left,target);
        root.right = dfs(root.right,target);
        if (root.val==target && root.left==null && root.right==null){
            return null;
        }
        return root;
    }
}

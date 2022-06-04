package zyj.yihong.leetcode.simple.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if (root==null){
            return 0;
        }

        int ans = 0;
        if (root.left!=null){

            // 判断当前节点是否是叶子节点
            if (root.left.left==null&&root.left.right==null){
                ans = ans+root.left.val;
            }else {
                int leftAns = dfs(root.left);
                ans += leftAns;
            }
        }

        if (root.right!=null){
            int rightAns = dfs(root.right);
            ans+=rightAns;
        }

        return ans;
    }
}

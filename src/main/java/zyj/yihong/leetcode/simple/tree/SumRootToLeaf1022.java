package zyj.yihong.leetcode.simple.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 */
public class SumRootToLeaf1022 {
    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }

    private static int dfs(TreeNode root,int ans){
        if (root==null){
            return 0;
        }

        int val = root.val;
        ans = (ans<<1)+val;

        int leftAns = dfs(root.left, ans);
        int rightAns = dfs(root.right, ans);
        if (leftAns==0&&rightAns==0){
            return ans;
        }
        return leftAns+rightAns;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right =treeNode7;

        int i = sumRootToLeaf(treeNode1);
        System.out.println(i);
    }
}

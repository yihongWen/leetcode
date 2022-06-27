package zyj.yihong.leetcode.special.top.tree;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 */
public class InsertIntoBST_M_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 使用迭代的方式
        if (root==null){
            return new TreeNode(val);
        }
        TreeNode parentNode = null;
        TreeNode curNode = root;
        boolean leftJoin = false;
        while (curNode!=null){
            parentNode = curNode;
            if (curNode.val<val){
                curNode = curNode.right;
                leftJoin = false;
            }else {
                curNode = curNode.left;
                leftJoin = true;
            }
        }

        TreeNode insertNode = new TreeNode(val);
        if (leftJoin){
            parentNode.left = insertNode;
        }else {
            parentNode.right = insertNode;
        }
        return root;
    }


    //  递归的方式进行插入
    public TreeNode dfs(TreeNode root,int val){
        if (root==null){
            return new TreeNode(val);
        }

        if (root.val<val){
            root.right = dfs(root.right,val);
        }

        if (root.val>val){
            root.left = dfs(root.left,val);
        }
        return root;
    }
}

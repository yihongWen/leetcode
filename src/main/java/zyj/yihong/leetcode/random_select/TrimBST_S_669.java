package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.TreeNode;

// 655. 输出二叉树
// 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
//
public class TrimBST_S_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // dfs 当前的节点存在三个状态
        // 1、属于low-high区间  2、low的左侧 3、high的右侧

        if (root==null){
            return null;
        }

        if (root.val>=low&&root.val<=high){
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }else if (root.val<low){
            return trimBST(root.right,low,high);
        }else {
            return trimBST(root.left,low,high);
        }
        return root;

    }
}

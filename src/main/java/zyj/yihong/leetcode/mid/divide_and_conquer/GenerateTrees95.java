package zyj.yihong.leetcode.mid.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
 */
public class GenerateTrees95 {
    public List<TreeNode> generateTrees(int n) {
        return divideAndConquer(1, n);
    }

    // 使用分治算法
    private List<TreeNode> divideAndConquer(int left, int right) {
        List<TreeNode> ans = new ArrayList<>();
        // 最小单元的情况,添加子节点为null后直接返回
        if (left>right){
            ans.add(null);
            return ans;
        }

        // 以当前节点为跟节点进行划分
        for (int i = left; i <=right ; i++) {
            List<TreeNode> leftTreeNodeList = divideAndConquer(left, i - 1);
            List<TreeNode> rightTreeNodeRight = divideAndConquer(i + 1, right);

            // 组装每一个不同的左右子树
            for (TreeNode curLeft : leftTreeNodeList) {
                for (TreeNode curRight : rightTreeNodeRight) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = curLeft;
                    treeNode.right = curRight;
                    ans.add(treeNode);
                }
            }
        }
        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

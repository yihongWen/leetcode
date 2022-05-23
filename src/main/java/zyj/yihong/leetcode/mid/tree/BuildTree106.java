package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class BuildTree106 {
    Map<Integer,Integer> inorderValueIndexMap = new HashMap<>();
    private int curRootIndex;
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderValueIndexMap.put(inorder[i],i);
        }
        curRootIndex = postorder.length-1;
        this.inorder = inorder;
        this.postorder = postorder;
        return builder(0,postorder.length-1);

    }

    public TreeNode builder(int left,int right){
        if (left>right){
            return null;
        }
        int rootValue = postorder[curRootIndex];
        TreeNode rootTree = new TreeNode(rootValue);
        curRootIndex--;
        Integer rootIndex = inorderValueIndexMap.get(rootValue);
        TreeNode rightTree = builder(rootIndex + 1, right);
        TreeNode leftTree = builder(left,rootIndex-1);
        rootTree.right = rightTree;
        rootTree.left = leftTree;
        return rootTree;
    }
}

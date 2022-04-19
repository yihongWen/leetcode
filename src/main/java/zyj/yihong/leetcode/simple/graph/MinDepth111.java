package zyj.yihong.leetcode.simple.graph;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth111 {

    private List<List<Integer>> ans = new ArrayList<>();

    List<String> sAns = new ArrayList<>();

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        }
        return Math.min(left, right) + 1;
    }


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> curAns) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ans.add(curAns);
            }
        }
        curAns.add(root.val);
        dfs(root.left, targetSum - root.val, new ArrayList<>(curAns));
        dfs(root.right, targetSum - root.val, new ArrayList<>(curAns));
    }


    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePathsDfs(root, new StringBuilder());
        return sAns;
    }

    public void binaryTreePathsDfs(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
            sAns.add(stringBuilder.toString());
            return;
        }
        stringBuilder.append(root.val).append("->");
        if (root.left==null&&root.right==null) {
            binaryTreePathsDfs(root.left, new StringBuilder(stringBuilder));
        }else if (root.left==null) {
            binaryTreePathsDfs(root.right, new StringBuilder(stringBuilder));
        }else if (root.right==null){
            binaryTreePathsDfs(root.left, new StringBuilder(stringBuilder));
        }else {
            binaryTreePathsDfs(root.right, new StringBuilder(stringBuilder));
            binaryTreePathsDfs(root.left, new StringBuilder(stringBuilder));
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(11);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(13);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(1);
        TreeNode treeNode10 = new TreeNode(5);


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode6;
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode6.left = treeNode7;
        treeNode6.right = treeNode8;
        treeNode8.right = treeNode9;
        treeNode8.left = treeNode10;
        MinDepth111 minDepth111 = new MinDepth111();
        List<String> b = minDepth111.binaryTreePaths(treeNode1);
        System.out.println(b);

    }

}

package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers129 {
    public static int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root==null){
            return ans;
        }
        List<TreeNode> curLevel = new ArrayList<>();
        curLevel.add(root);
        List<TreeNode> nextLevel = new ArrayList<>();

        while (curLevel.size()!=0){
            for (TreeNode curNode : curLevel) {
                if (curNode.left==null&&curNode.right==null){
                    ans+= curNode.val;
                }

                if (curNode.left!=null){
                    int val = curNode.left.val;
                    val = curNode.val*10+val;
                    curNode.left.val = val;
                    nextLevel.add(curNode.left);
                }

                if (curNode.right!=null){
                    int val = curNode.right.val;
                    val = curNode.val*10+val;
                    curNode.right.val = val;
                    nextLevel.add(curNode.right);
                }
            }

            curLevel.clear();
            List<TreeNode> temp = curLevel;
            curLevel = nextLevel;
            nextLevel = temp;
        }

        return ans;

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left =treeNode2;
        treeNode1.right =treeNode3;
        int i = sumNumbers(treeNode1);
        System.out.println(i);
    }

}

package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LevelOrderBottom107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Stack<List<TreeNode>> stack = new Stack<>();
        List<TreeNode> rootList = Arrays.asList(root);
        stack.add(rootList);
        boolean unHandle = false;
        while (!unHandle){
            List<TreeNode> peek = stack.peek();
            List<TreeNode> curLevel = new ArrayList<>();
            for (int i = 0; i < peek.size(); i++) {
                TreeNode treeNode = peek.get(i);
                if (treeNode.left!=null){
                    curLevel.add(treeNode.left);
                }

                if (treeNode.right!=null){
                    curLevel.add(treeNode.right);
                }
            }
            if (curLevel.size()!=0){
                stack.add(curLevel);
            }else {
                unHandle = true;
            }
        }

        while (!stack.isEmpty()){
            List<TreeNode> pop = stack.pop();
            List<Integer> culLevelValue = new ArrayList<>();
            for (int i = 0; i < pop.size(); i++) {
                culLevelValue.add(pop.get(i).val);
            }
            ans.add(culLevelValue);
        }

        return ans;
    }



}

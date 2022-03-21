package zyj.yihong.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class FindTarget653 {
    /**
     * 中序遍历、生成数组、双指针
     *
     * @param root
     * @param k
     * @return
     */
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorderGenArr(root, arr);
        int i = 0;
        int j = arr.size()-1;

        while (i < j) {
            int i1 = arr.get(i);
            int j1 = arr.get(j);
            int curValue = i1+j1;

            if (curValue==k){
                return true;
            }else if (curValue<k){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    private static void inorderGenArr(TreeNode root, List<Integer> arr) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                arr.add(pop.val);
                curNode = pop.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        boolean target = findTarget(treeNode2, 1);
        System.out.println(target);

    }


    static class TreeNode {
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

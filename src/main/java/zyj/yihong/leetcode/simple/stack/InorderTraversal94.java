package zyj.yihong.leetcode.simple.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 */
public class InorderTraversal94 {

    private List<Integer> recursionList = new ArrayList<>();

    /**
     * 使用栈的方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retArray = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || nodeStack.size()>0){
            while (cur!=null){
                nodeStack.push(cur);
                cur = cur.left;
            }

            if (nodeStack.size()>0){
                TreeNode pop = nodeStack.pop();
                retArray.add(pop.val);
                cur = pop.right;
            }
        }
        return retArray;
    }

    /**
     * 先序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> retArray = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || nodeStack.size()>0){
            while (cur!=null){
                nodeStack.push(cur);
                retArray.add(cur.val);
                cur = cur.left;
            }

            if (nodeStack.size()>0){
                TreeNode pop = nodeStack.pop();
                cur = pop.right;
            }
        }
        return retArray;
    }


    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retArray = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastNode = cur;
        while(cur!=null || nodeStack.size()>0){
            while (cur!=null){
                nodeStack.push(cur);
                cur = cur.left;
            }
            cur = nodeStack.peek();
            if (cur.right==null || cur.right == lastNode){
                nodeStack.pop();
                retArray.add(cur.val);
                lastNode = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
        return retArray;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        inorderTraversalRecursion(root);
        return recursionList;
    }


    public void inorderTraversalRecursion(TreeNode root) {
        if (root==null){
            return;
        }
        inorderTraversalRecursion(root.left);
        recursionList.add(root.val);
        inorderTraversalRecursion(root.right);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}

package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 655. 输出二叉树
public class PrintTree_M_655 {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        int treeHeight = getTreeHeight(root)-1;
        int right = (int)Math.pow(2, treeHeight + 1) - 1;
        for (int i = 0; i <= treeHeight ; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < right; j++) {
                cur.add("");
            }
            ans.add(cur);
        }
        printDfs(root,0,right-1,0);

        return ans;
    }

    private void printDfs(TreeNode node,int left,int right,int level){
        if (node==null){
            return;
        }
        List<String> strings = ans.get(level);
        int mid = left + ((right - left) >> 1);
        strings.set(mid,String.valueOf(node.val));

        if (node.left!=null){
            printDfs(node.left,left,mid-1,level+1);
        }
        if (node.right!=null){
            printDfs(node.right,mid+1,right,level+1);
        }
    }

    private int getTreeHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1+Math.max(getTreeHeight(root.left),getTreeHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        PrintTree_M_655 printTree_m_655 = new PrintTree_M_655();
        List<List<String>> lists = printTree_m_655.printTree(treeNode1);
        System.out.println(lists);

    }
}

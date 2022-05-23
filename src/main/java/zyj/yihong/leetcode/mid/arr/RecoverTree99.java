package zyj.yihong.leetcode.mid.arr;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 */
public class RecoverTree99 {
    public void recoverTree(TreeNode root) {
        // 中序遍历查找所有的数据
        List<Integer> container = new ArrayList<>();
        midSort(root,container);

        // 找出错乱的两个节点
        boolean first = true;
        int firstNodeIndex = 0;
        int secondNodeIndex = 0;
        for (int i = 0; i < container.size()-1; i++) {
            if (container.get(i)>container.get(i+1)){
                if (first){
                    firstNodeIndex = i;
                    first = false;
                }else {
                    secondNodeIndex = i+1;
                }
            }
        }
        if (secondNodeIndex==0){
            secondNodeIndex=firstNodeIndex+1;
        }

        modify(root,container.get(firstNodeIndex),container.get(secondNodeIndex));
    }

    // 修正二叉搜索树
    private void modify(TreeNode root,int first,int second){
        if (root==null){
            return;
        }
        if (root.val==first){
            root.val = second;
        }else if (root.val==second){
            root.val = first;
        }

        modify(root.left,first,second);
        modify(root.right,first,second);

    }

    private List<Integer> midSort(TreeNode root,List<Integer> container){
        if (root==null){
            return container;
        }
        midSort(root.left,container);
        container.add(root.val);
        midSort(root.right,container);
        return container;
    }

    public static void main(String[] args) {
        RecoverTree99 recoverTree99 = new RecoverTree99();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode4.left = treeNode2;
        recoverTree99.recoverTree(treeNode3);
        System.out.println(treeNode1.val);

    }
}

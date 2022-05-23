package zyj.yihong.leetcode.mid.binary_search;

import zyj.yihong.leetcode.utils.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 *
 */
public class CountNodes222 {
    public static int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        // 计算出tree的深度level
        int level = 0;
        TreeNode curNode = root;
        while (curNode.left!=null){
            curNode=curNode.left;
            level++;
        }

        // 计算区间值
        int min =  1<<level;
        int max = (1<<level+1)-1;

        // 二分查找：min->max中的值，也就是最后一层的最后一个值，
        // 此时min是一定存在，而max未知
        while (min<max){
            // 向后偏移，因为后面可能不存在，从而使得max进行缩减
            int mid = (max-min+1)/2+min;
            TreeNode findNode = root;
            int bit = 1<<(level-1);
            while (findNode!=null&&bit>0){
                if ((mid&bit)==0){
                    findNode=findNode.left;
                }else {
                    findNode = findNode.right;
                }
                bit = bit>>1;
            }

            if (findNode==null){
                max = mid-1;
            }else {
                min = mid;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        TreeNode curNode1 = new TreeNode(1);
        TreeNode curNode2 = new TreeNode(2);
        TreeNode curNode3 = new TreeNode(3);
        TreeNode curNode4 = new TreeNode(4);
        TreeNode curNode5 = new TreeNode(5);
        TreeNode curNode6 = new TreeNode(6);
        curNode1.left = curNode2;
        curNode1.right = curNode3;
        curNode2.left = curNode4;
        curNode2.right = curNode5;
        curNode3.left = curNode6;
        int i = countNodes(curNode1);
        System.out.println(i);


    }
}

package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * zigzagLevelOrder
 */
public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }

        // 广度优先搜索：实现层序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // 标记当前方向
        boolean directorLeft = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            // 在每一层中使用双端队列
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.right!=null){
                    queue.add(poll.right);
                }

                if (poll.left!=null){
                    queue.add(poll.left);
                }

                if (directorLeft){
                    curLevel.addLast(poll.val);
                }else {
                    curLevel.addFirst(poll.val);
                }
            }
            directorLeft = !directorLeft;
            ans.add(curLevel);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;


        ZigzagLevelOrder103 zigzagLevelOrder103 = new ZigzagLevelOrder103();
        List<List<Integer>> lists = zigzagLevelOrder103.zigzagLevelOrder(treeNode1);
        System.out.println(lists);

    }

}

package zyj.yihong.leetcode.mid.tree;

import org.omg.CORBA.PRIVATE_MEMBER;
import zyj.yihong.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 */
public class PathSum437 {
    private Map<Integer,Integer> map;
    private int targetSum,curSum;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0,1);
        this.targetSum = targetSum;
        curSum = 0;
        int ans = dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        // 如果root为空，返回0
        if (root==null){
            return 0;
        }

        int ans;
        curSum += root.val;

        // 判断是否存在满足
        ans = map.getOrDefault(curSum-targetSum,0);

        // 为下一个节点，准备,将当前节点的前缀和
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        int leftAns = dfs(root.left);
        int rightAns = dfs(root.right);
        ans+=leftAns+rightAns;
        map.put(curSum,map.getOrDefault(curSum,0)-1);
        curSum-= root.val;
        return ans;
    }

    public static void main(String[] args) {
//        [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;

        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        treeNode6.left = treeNode9;
        treeNode6.right = treeNode10;

        PathSum437 pathSum437 = new PathSum437();
        int i = pathSum437.pathSum(treeNode1, 22);
        System.out.println(i);

    }
}

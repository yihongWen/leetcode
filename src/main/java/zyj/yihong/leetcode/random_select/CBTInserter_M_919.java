package zyj.yihong.leetcode.random_select;

import zyj.yihong.leetcode.utils.ListNode;
import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 */
public class CBTInserter_M_919 {
    private TreeNode root;
    private Queue<TreeNode> queue;

    public CBTInserter_M_919(TreeNode root) {
        this.root = root;
        queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode peek = queue.peek();
            if (peek.left!=null){
                queue.add(peek.left);
            }
            if (peek.right!=null){
                queue.add(peek.right);
                queue.poll();
                continue;
            }
            break;
        }

    }

    public int insert(int val) {
        TreeNode peek = queue.peek();
        TreeNode insertNode = new TreeNode(val);
        if (peek.left==null){
            peek.left = insertNode;
            queue.add(insertNode);
        }else if (peek.right == null){
            peek.right = insertNode;
            queue.add(insertNode);
            queue.poll();
        }
        return peek.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
//        ["CBTInserter","insert","insert","get_root"]
//[[[1,2]],[3],[4],[]]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;



        CBTInserter_M_919 cbtInserter_m_919 = new CBTInserter_M_919(node1);
        cbtInserter_m_919.insert(3);
        cbtInserter_m_919.insert(4);
        System.out.println("----------end--------");
    }
}

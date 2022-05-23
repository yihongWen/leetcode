package zyj.yihong.leetcode.mid.tree;

import zyj.yihong.leetcode.utils.ListNode;
import zyj.yihong.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。
 */
public class SortedListToBST109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> valueList = new ArrayList<>();
        ListNode curNode = head;
        while (curNode!=null){
            valueList.add(curNode.val);
            curNode = curNode.next;
        }

        if (valueList.size()==0){
            return null;
        }

        // 二分进行构造平衡树：
        return build(valueList,0,valueList.size()-1);

    }

    public TreeNode build(List<Integer> value,int left,int right){
        if (left>right){
            return null;
        }

        int mid = (right-left)/2+left;
        TreeNode root = new TreeNode(value.get(mid));
        root.left = build(value,left,mid-1);
        root.right = build(value,mid+1,right);
        return root;
    }


    public static void main(String[] args) {
        SortedListToBST109 sortedListToBST109 = new SortedListToBST109();
        int[] arr = {-10,-3,0,5,9};
        ListNode fake = new ListNode(0);
        ListNode cur = fake;
        for (int i : arr) {
            ListNode listNode = new ListNode(i);
            cur.next = listNode;
            cur = listNode;
        }

        TreeNode treeNode = sortedListToBST109.sortedListToBST(fake.next);
        System.out.println(treeNode);
    }
}

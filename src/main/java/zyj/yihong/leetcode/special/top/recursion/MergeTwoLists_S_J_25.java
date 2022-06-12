package zyj.yihong.leetcode.special.top.recursion;

import zyj.yihong.leetcode.utils.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 */
public class MergeTwoLists_S_J_25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 使用递归的方式：每次选出当前最小的节点，然后递归

        // 结束条件
        if (l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }

        // 选择出当前较小的点
        if (l1.val< l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}

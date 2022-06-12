package zyj.yihong.leetcode.special.top.recursion;

import zyj.yihong.leetcode.utils.ListNode;

public class ReverseList_S_J2_24 {
    public ListNode reverseList(ListNode head) {
        // 边界判断
        if (head==null||head.next==null){
            return head;
        }

        // 细节点，为了将最后一个节点层层往上返回
        // 不能使用reNode.next = head;

        ListNode reNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reNode;
    }
}

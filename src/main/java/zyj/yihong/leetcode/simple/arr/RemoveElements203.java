package zyj.yihong.leetcode.simple.arr;

import zyj.yihong.leetcode.utils.ListNode;

/**
 * 203. 移除链表元素
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0,head);
        ListNode preNode = fakeHead;
        ListNode curNode = head;
        while (curNode!=null){
            if (curNode.val==val){
                curNode = curNode.next;
                preNode.next = curNode;
            }else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return fakeHead.next;
    }
}

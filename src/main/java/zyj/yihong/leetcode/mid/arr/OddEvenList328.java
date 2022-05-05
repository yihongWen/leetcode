package zyj.yihong.leetcode.mid.arr;

import java.util.List;

/**
 * 328. 奇偶链表
 */
public class OddEvenList328 {
    public static ListNode oddEvenList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode roo1 = head;
        ListNode roo2 = head.next;
        ListNode head2 = head.next;

        while (true){
            if (roo2==null){
                roo1.next = head2;
                return head;
            }

            roo1.next = roo2.next;
            if (roo1.next!=null) {
                roo2.next = roo1.next.next;
            }
            if (roo1.next==null){
                roo1.next = head2;
                break;
            }
            roo1 = roo1.next;
            roo2 = roo2.next;


        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode node1 = OddEvenList328.oddEvenList(node);
        System.out.println(node1);

    }


     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}

package zyj.yihong.leetcode.simple.link;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 */
public class ReorderList143 {
    public static void reorderList(ListNode head) {
        if (head==null || head.next==null){
            return;
        }

        // 找到链表的中间节点
        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode.next!=null){
            if (fastNode.next.next!=null){
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
                continue;
            }
            break;
        }

        // 分成左右两个链表、将第二个链表反转
        ListNode cur = slowNode.next;
        ListNode pre = null;
        slowNode.next = null;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 重排
        ListNode firstCurNode = head;
        ListNode secondCurNode = pre;
        ListNode newListHead = new ListNode();
        ListNode newCurNode = newListHead;
        while (firstCurNode!=null && secondCurNode!=null){
            newCurNode.next = firstCurNode;
            firstCurNode = firstCurNode.next;
            newCurNode = newCurNode.next;
            newCurNode.next = secondCurNode;
            secondCurNode = secondCurNode.next;
            newCurNode = newCurNode.next;
        }
        if (firstCurNode!=null){
            newCurNode.next = firstCurNode;
        }
        head = newListHead.next;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        reorderList(listNode1);

    }

}

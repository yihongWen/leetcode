package zyj.yihong.leetcode.simple.link;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode876 {
    /**
     * 使用快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slowPoint = head;
        ListNode fastPoint = head;

        while (fastPoint.next!=null){
            if (fastPoint.next.next==null){
                return slowPoint.next;
            }else {
                slowPoint = slowPoint.next;
                fastPoint =  fastPoint.next.next;
            }
        }
        return slowPoint;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

package zyj.yihong.leetcode.simple.recursion;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class IsPalindrome234 {


    private ListNode curHeadPoint;

    public boolean isPalindrome(ListNode head) {
        curHeadPoint = head;
        return recursionCheck(head);
    }


    public boolean recursionCheck(ListNode node){
        if (node!=null){
            if (!recursionCheck(node.next)){
                return false;
            }

            // 后一个跟前面相同
            if (node.val!=curHeadPoint.val){
                return false;
            }

            curHeadPoint = curHeadPoint.next;
        }

        // 走到最尾巴
        return true;
    }



    public class ListNode {
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

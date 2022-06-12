package zyj.yihong.leetcode.special.top.recursion;

import zyj.yihong.leetcode.utils.ListNode;

/**
 * 面试题 02.05. 链表求和
 */
public class AddTwoNumbers_M_M0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, false);
    }

    public ListNode dfs(ListNode root1, ListNode root2, boolean carry) {
        if (root1==null&&root2==null&&(!carry)){
            return null;
        }else if (root1 == null && root2 == null){
            return new ListNode(1);
        }else if (root1==null){
            int num = root2.val + (carry ? 1 : 0);
            boolean nextCarry = num/10>0;
            int consult = num%10;
            ListNode nextNode = dfs(null, root2.next, nextCarry);
            ListNode listNode = new ListNode(consult);
            listNode.next = nextNode;
            return listNode;
        }else if (root2==null){
            int num = root1.val + (carry ? 1 : 0);
            boolean nextCarry = num/10>0;
            int consult = num%10;
            ListNode nextNode = dfs(root1.next, null, nextCarry);
            ListNode listNode = new ListNode(consult);
            listNode.next = nextNode;
            return listNode;
        }else {
            int num = root1.val+ root2.val + (carry ? 1 : 0);
            boolean nextCarry = num/10>0;
            int consult = num%10;
            ListNode nextNode = dfs(root1.next, root2.next, nextCarry);
            ListNode listNode = new ListNode(consult);
            listNode.next = nextNode;
            return listNode;
        }
    }

}

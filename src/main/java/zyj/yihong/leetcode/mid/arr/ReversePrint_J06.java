package zyj.yihong.leetcode.mid.arr;

public class ReversePrint_J06 {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode curNode = head;
        while (curNode!=null){
            count++;
            curNode = curNode.next;
        }

        int[] ans = new int[count];

        curNode = head;
        for (int i = count-1; i >=0 ; i--) {
            ans[i] = curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }

    public ListNode deleteNode(ListNode head, int val) {
        // 边界处理：如果删除的是根节点
        if (head.val == val){
            return head.next;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;

        while (curNode!=null){
            if (curNode.val==val){
                preNode.next = curNode.next;
                return head;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}

package zyj.yihong.leetcode.mid.stack;

import java.util.Stack;

/**
 * 445. 两数相加 II
 */
public class AddTwoNumbers455 {

    /**
     * 使用栈
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        ListNode l1CurNode = l1;
        ListNode l2CurNode = l2;

        while (l1CurNode != null) {
            l1Stack.push(l1CurNode.val);
            l1CurNode = l1CurNode.next;
        }

        while (l2CurNode != null) {
            l2Stack.push(l2CurNode.val);
            l2CurNode = l2CurNode.next;
        }

        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()){
            int cur1 = l1Stack.isEmpty()?0:l1Stack.pop();
            int cur2 = l2Stack.isEmpty()?0: l2Stack.pop();
            int curRet = (cur1+cur2+carry)%10;
            carry = (cur1+cur2+carry)/10;
            resultStack.push(curRet);
        }
        ListNode resultNodeRoot = new ListNode();
        ListNode resultNodeCur = resultNodeRoot;

        if (carry==1){
            resultStack.push(1);
        }

        while (!resultStack.isEmpty()){
            ListNode listNode = new ListNode(resultStack.pop());
            resultNodeCur.next = listNode;
            resultNodeCur = resultNodeCur.next;
        }
        return resultNodeRoot.next;

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

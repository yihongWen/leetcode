package zyj.yihong.leetcode.mid.sort;

/**
 * 对链表进行插入排序
 */
public class InsertionSortList147 {
    public static ListNode insertionSortList(ListNode head) {
        // 校验
        if (head==null||head.next==null){
            return head;
        }

        ListNode curNode = head.next;
        ListNode preCurNode = head;
        while (curNode!=null){
            // 排序逻辑
            ListNode curCompareNode = head;
            ListNode curPreCompareNode = null;
            ListNode curNextNode = curNode.next;

            while (true){
                if (curCompareNode==curNode){
                    preCurNode = curNode;
                    curNode = curNextNode;
                    break;
                }

                if (curCompareNode.val> curNode.val){
                    // 交换位置
                    if (curPreCompareNode!=null){
                        curPreCompareNode.next = curNode;
                    }else {
                        head = curNode;
                    }
                    curNode.next = curCompareNode;
                    preCurNode.next = curNextNode;
                    curNode = curNextNode;
                    break;
                }
                curPreCompareNode = curCompareNode;
                curCompareNode = curCompareNode.next;
            }

        }

        return head;

    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
//        输入: 4->2->1->3
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node = insertionSortList(head);

        System.out.println(node);

    }

}

package zyj.yihong.leetcode.mid.sort;

/**
 * 排序链表
 */
public class SortList148 {
    public static ListNode sortList(ListNode head) {
        ListNode listNode = mergeSort(head, null);
        return listNode;
    }


    /**
     * 并归排序: 双指针+边界特殊处理
     * @param head
     * @param tail
     * @return
     */
    public static ListNode mergeSort(ListNode head,ListNode tail){

        // 递归结束的条件
//        if (head == null) {
//            return head;
//        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        // 如果fast走到tail那么slow则走到中点
        while(fastNode!=tail){
            fastNode = fastNode.next;
            slowNode = slowNode.next;

            // 判断fast走出一步时是否为空、避免空指针
            if (fastNode!=tail){
                fastNode= fastNode.next;
            }
        }

        ListNode mid = slowNode;
        ListNode list1 = mergeSort(head, mid);
        ListNode list2 = mergeSort(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;

    }

    /**
     * 合并两个有序链表（两个链表不为空）
     * @param nodeHead1
     * @param nodeHead2
     * @return
     */
    public static ListNode merge(ListNode nodeHead1,ListNode nodeHead2){

        ListNode curNode1 = nodeHead1;
        ListNode curNode2 = nodeHead2;
        // 哑节点
        ListNode preRetHead = new ListNode(0);
        ListNode curRetNode = preRetHead;


        while(curNode1!=null && curNode2!=null){
            if (curNode1.val< curNode2.val){
                curRetNode.next = curNode1;
                curNode1=curNode1.next;
            }else {
                curRetNode.next = curNode2;
                curNode2 = curNode2.next;
            }
            curRetNode = curRetNode.next;
        }

        // 如果存在一个链表提前遍历到结束的点
        if (curNode1==null){
            curRetNode.next = curNode2;
        }else {
            curRetNode.next = curNode1;
        }

        return preRetHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode2.next = listNode4;
        listNode1.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode2;
        ListNode sortList = sortList(listNode1);

        System.out.println(sortList);



    }


    public static class ListNode {
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

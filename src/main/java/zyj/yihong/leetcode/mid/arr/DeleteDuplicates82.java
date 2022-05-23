package zyj.yihong.leetcode.mid.arr;

import zyj.yihong.leetcode.utils.ListNode;


public class DeleteDuplicates82 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakeNode = new ListNode();
        fakeNode.next = head;
        ListNode preNode = fakeNode;
        ListNode curNode = head;
        boolean dup = false;
        while (curNode != null) {
            if (curNode.next != null && curNode.next.val == curNode.val) {
                curNode = curNode.next;
                dup = true;
            } else if (curNode.next != null) {
                if (dup) {
                    preNode.next = curNode.next;
                    curNode = curNode.next;
                } else {
                    preNode = curNode;
                    curNode = curNode.next;
                }
                dup = false;
            } else {
                if (dup) {
                    preNode.next = null;
                    curNode = null;
                } else {
                    curNode = null;
                }
            }
        }
        return fakeNode.next;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode fakeNode = new ListNode();
        fakeNode.next = head;

        ListNode preNode = fakeNode;
        ListNode curNode = fakeNode.next;
        ListNode lessLastNode = fakeNode;

        while (curNode != null) {
            if (curNode.val >= x) {
                preNode = curNode;
                curNode = curNode.next;
                continue;
            }

            if (preNode != lessLastNode) {
                ListNode tempLessNode = lessLastNode.next;
                lessLastNode.next = curNode;
                preNode.next = curNode.next;
                curNode.next = tempLessNode;
                lessLastNode = lessLastNode.next;
                curNode = preNode.next;
            } else {
                preNode = curNode;
                lessLastNode = curNode;
                curNode = curNode.next;
            }
        }

        return fakeNode.next;
    }


    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            int i = columnNumber % 26;
            columnNumber = columnNumber / 26;
            sb.insert(0, (char) ('A' + i));
        }
        return sb.toString();
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 分别找到左边跟右边的端点
        ListNode fake = new ListNode();
        fake.next = head;
        ListNode leftNode = fake;
        ListNode leftPreNode = fake;
        ListNode rightNode = fake;
        ListNode rightNextNode = fake;
        ListNode preNode = fake;
        ListNode curNode = head;
        int count = 0;
        while (curNode!=null){
            count++;
            if (count==left){
                leftNode = curNode;
                leftPreNode = preNode;
                preNode.next = null;

            }

            if (count==right){
                rightNode = curNode;
                rightNextNode = curNode.next;
                curNode.next = null;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }

        // 反转链表
        reverse(leftNode);

        leftPreNode.next = rightNode;
        leftNode.next = rightNextNode;
        return fake.next;
    }

    private static ListNode reverse(ListNode root){
        ListNode curNode = root;
        ListNode preNode = null;
        while (curNode!=null){
            ListNode temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }
        return preNode;
    }

    public static void main(String[] args) {
        int[] arr = {5};
        ListNode head = new ListNode();
        ListNode curNode = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            curNode.next = listNode;
            curNode = listNode;
        }
        ListNode listNode = reverseBetween(head.next, 1, 1);
        System.out.println(listNode.val);

    }
}

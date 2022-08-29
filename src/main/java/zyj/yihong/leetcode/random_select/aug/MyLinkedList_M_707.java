package zyj.yihong.leetcode.random_select.aug;

// 707. 设计链表
public class MyLinkedList_M_707 {

    private Node head;
    public MyLinkedList_M_707() {
        head = new Node();
    }

    public int get(int index) {
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            if (cur.next==null){
                return -1;
            }
            cur = cur.next;
        }
        return cur.val;
    }

    // 在头部添加
    public void addAtHead(int val) {
        Node node = new Node();
        node.val = val;
        Node hNext = head.next;
        head.next = node;
        node.next = hNext;
    }

    // 在尾部添加
    public void addAtTail(int val) {
        Node curNode = head;
        while (curNode.next!=null){
            curNode = curNode.next;
        }

        Node node = new Node();
        node.val = val;
        curNode.next = node;
    }

    // 在指定index添加，如果<0 添加在头部  如果长度小于index那么不添加
    public void addAtIndex(int index, int val) {
        Node curNode = head;

        if (index<0){
            this.addAtHead(val);
            return;
        }

        for (int i = 0; i < index; i++) {
            if (curNode.next!=null){
                curNode = curNode.next;
            }else {
               if (i<=index-1){
                   return;
               }
                break;
            }
        }

        Node node = new Node();
        node.val = val;
        Node next = curNode.next;
        curNode.next = node;
        node.next = next;
    }


    // 指定位置删除
    public void deleteAtIndex(int index) {
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            if (curNode.next!=null){
                curNode = curNode.next;
            }else {
                return;
            }
        }

        if (curNode.next==null){
            return;
        }

        curNode.next = curNode.next.next;
    }


    static class Node{
        public int val;
        public Node next;
    }

    public static void main(String[] args) {
        MyLinkedList_M_707 myLinkedList_m_707 = new MyLinkedList_M_707();
//["MyLinkedList","addAtIndex","get"]
//[[],[1,0],[0]]
        myLinkedList_m_707.addAtIndex(1,0);
        int i1 = myLinkedList_m_707.get(0);
        System.out.println(i1);


    }
}

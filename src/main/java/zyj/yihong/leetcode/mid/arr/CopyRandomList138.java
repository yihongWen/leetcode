package zyj.yihong.leetcode.mid.arr;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 */
public class CopyRandomList138 {
    public Node copyRandomList(Node head) {

        if (head==null){return null;}

        Node cur = head;

        // copy
        while (cur!=null){
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }

        // 处理random指针
        cur = head;
        while (cur!=null){
            Node temp = cur.next.next;
            cur.next.random = cur.random==null?null:cur.random.next;
            cur = temp;
        }


        cur = head;
        Node retNode = head.next;
        while (cur!=null){
            Node temp = cur.next.next;
            cur.next.next = cur.next.next==null?null:cur.next.next.next;
            cur.next =temp;
            cur = temp;
        }
        return retNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyRandomList138 copyRandomList138 = new CopyRandomList138();
        Node node = copyRandomList138.copyRandomList(node1);
        System.out.println(node);


    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

package zyj.yihong.datastruct.tree;

import lombok.Data;

import java.util.*;

/**
 * 二叉树
 */
public class BinaryTree {

    private Node head;


    public BinaryTree() {
    }


    /**
     * 查询是否存在某个值：使用递归的方式
     *
     * @param node
     * @param queryValue
     * @return
     */
    public boolean existValue(Node node, int queryValue) {
        if (node == null) {
            return false;
        }
        if (node.value == queryValue) {
            return true;
        } else if (node.value < queryValue) {
            return existValue(node.right, queryValue);
        } else {
            return existValue(node.left, queryValue);
        }
    }

    public boolean existValueByLoop(int queryValue) {
        Node cur = head;
        while (cur != null) {
            if (cur.value == queryValue) {
                return true;
            } else if (cur.value > queryValue) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    /**
     * 查询当前节点为树根的最大值
     *
     * @return
     */
    public Node queryMax(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        while (cur.getRight() != null) {
            cur = cur.getRight();
        }
        return cur;
    }

    /**
     * 查询当前节点为树根的最小值
     *
     * @param node
     * @return
     */
    public Node queryMin(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        while (cur.getRight() != null) {
            cur = cur.getRight();
        }
        return cur;
    }


    /**
     * 查询当前节点的后继
     *
     * @param node
     * @return
     */
    public Node querySuccessor(Node node) {
        Node curNode = node;
        // 如果节点为空或者当前节点就是最大节点，此时没有后继节点
        if (curNode == null || Objects.equals(curNode, queryMax(head))) {
            return null;
        }

        // 如果当前节点右孩子不为空
        if (curNode.getRight() != null) {
            return queryMin(curNode.getRight());
        }

        // 如果是右孩子，那么往上走(如果是走到了这一步就一定会有结果)
        Node pNode = curNode.getParent();
        while (pNode != null && Objects.equals(pNode.right, curNode)) {
            curNode = pNode;
            pNode = pNode.getParent();
        }
        return pNode;
    }


    /**
     * 查询前驱
     *
     * @param node
     * @return
     */
    public Node queryPrecursor(Node node) {
        Node curNode = node;
        // 如果节点为空或者当前节点就是最大节点，此时没有后继节点
        if (curNode == null || Objects.equals(curNode, queryMin(head))) {
            return null;
        }

        // 如果当前节点右孩子不为空
        if (curNode.getLeft() != null) {
            return queryMax(curNode.getLeft());
        }

        // 如果是左孩子，那么往上走(如果是走到了这一步就一定会有结果)
        Node pNode = curNode.getParent();
        while (pNode != null && Objects.equals(pNode.left, curNode)) {
            curNode = pNode;
            pNode = pNode.getParent();
        }
        return pNode;
    }

    /**
     * 交换两颗子树
     *
     * @param originNode
     * @param replaceNode
     */
    public void transplant(Node originNode, Node replaceNode) {
        if (originNode == null) {
            return;
        }

        // 如果是根节点
        if (originNode.getParent() == null) {
            head = replaceNode;
            return;
        }

        // 将替换的节点指向父节点
        Node parent = originNode.getParent();

        // 确定父节点的左右
        if (Objects.equals(parent.getLeft(), originNode)) {
            parent.setLeft(replaceNode);
        } else {
            parent.setRight(replaceNode);
        }

        if (replaceNode != null) {
            replaceNode.setParent(parent);
        }

    }

    /**
     * 插入数据
     *
     * @param i
     */
    public void insert(int i) {
        // 插入的树如果是一颗空树
        if (head==null){
            Node node = new Node(i);
            head = node;
        }

        // 找到位置
        Node cur = head;
        Node preNode = head;

        while(cur!=null){
            preNode = cur;
            if (cur.value<i){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }

        Node node = new Node(i);
        if (node.value>preNode.value){
            preNode.right = node;
        }else {
            preNode.left = node;
        }
        node.setParent(preNode);

    }

    /**
     * 删除节点
     *
     * @param i
     */
    public void delete(int i) {

    }

    /**
     * 先序遍历：借助于栈的结构
     * @return
     */
    public Integer[] preSearch() {
        Node cur = head;
        List<Integer> retList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        while (cur!=null || (!stack.isEmpty())){
            while (cur!=null){
                stack.push(cur);
                retList.add(cur.getValue());
                cur = cur.left;
            }

            if (!stack.isEmpty()){
                Node pop = stack.pop();
                cur = pop.right;
            }
        }
        return retList.toArray(new Integer[0]);
    }

    /**
     * 中序遍历：
     * @return
     */
    public Integer[] midSearch() {
        Node cur = head;
        List<Integer> retList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        while(cur!=null || !stack.isEmpty() ){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()){
                Node pop = stack.pop();
                retList.add(pop.getValue());
                cur = pop.right;
            }
        }
        return retList.toArray(new Integer[0]);
    }

    /**
     * 后序遍历
     * @return
     */
    public Integer[] afterSearch() {
        Node cur = head;
        Node lastNode = cur;
        List<Integer> retList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        while(cur!=null || !stack.isEmpty() ){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (cur.right==null || cur.right==lastNode){
                stack.pop();
                retList.add(cur.getValue());
                lastNode = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }
        return retList.toArray(new Integer[0]);
    }

    /**
     * 同中序遍历
     * @return
     */
    public int[] depthSearch() {
        return null;
    }

    /**
     * 广度优先搜索：使用队列(set标记,如果是图则需要进行标记)
     * @return
     */
    public Integer[] breadthSearch() {
        Node cur = head;
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> retList = new ArrayList<>();
        if (cur!=null){
            queue.add(cur);
        }

        while(queue.size()!=0){
            Node poll = queue.poll();
            retList.add(poll.getValue());
            if (poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.right!=null){
                queue.add(poll.right);
            }
        }
        return retList.toArray(new Integer[0]);
    }


    @Data
    private static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        binaryTree.head = node1;
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        Integer[] integers = binaryTree.midSearch();
        System.out.println(Arrays.toString(integers));


    }
}

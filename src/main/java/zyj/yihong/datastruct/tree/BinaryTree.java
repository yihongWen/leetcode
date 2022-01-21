package zyj.yihong.datastruct.tree;

import lombok.Data;

import java.util.Objects;

/**
 * 二叉树
 */
public class BinaryTree {

    private Node head;


    public BinaryTree() {
    }


    /**
     * 查询是否存在某个值：使用递归的方式
     * @param node
     * @param queryValue
     * @return
     */
    public boolean existValue(Node node ,int queryValue){
        if (node==null){
            return false;
        }
        if (node.value==queryValue){
            return true;
        }else if (node.value<queryValue){
            return existValue(node.right,queryValue);
        }else {
            return existValue(node.left,queryValue);
        }
    }

    public boolean existValueByLoop(int queryValue){
        Node cur = head;
        while(cur!=null){
            if (cur.value == queryValue){
                return true;
            }else if (cur.value>queryValue){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return false;
    }

    /**
     * 查询当前节点为树根的最大值
     * @return
     */
    public Node queryMax(Node node){
        if(node==null){
            return null;
        }
        Node cur = node;
        while(cur.getRight()!=null){
            cur = cur.getRight();
        }
        return cur;
    }

    /**
     * 查询当前节点为树根的最小值
     * @param node
     * @return
     */
    public Node queryMin(Node node){
        if(node==null){
            return null;
        }
        Node cur = node;
        while(cur.getRight()!=null){
            cur = cur.getRight();
        }
        return cur;
    }


    /**
     * 查询当前节点的后继
     * @param node
     * @return
     */
    public Node querySuccessor(Node node){
        Node curNode = node;
         // 如果节点为空或者当前节点就是最大节点，此时没有后继节点
        if (curNode==null || Objects.equals(curNode,queryMax(head))){
            return null;
        }

        // 如果当前节点右孩子不为空
        if (curNode.getRight()!=null) {
            return queryMin(curNode.getRight());
        }

        // 如果是右孩子，那么往上走(如果是走到了这一步就一定会有结果)
        Node pNode = curNode.getParent();
        while(pNode!=null && Objects.equals(pNode.right,curNode)){
            curNode = pNode;
            pNode = pNode.getParent();
        }
        return pNode;
    }


    /**
     * 查询前驱
     * @param node
     * @return
     */
    public Node queryPrecursor(Node node){
        Node curNode = node;
        // 如果节点为空或者当前节点就是最大节点，此时没有后继节点
        if (curNode==null || Objects.equals(curNode,queryMin(head))){
            return null;
        }

        // 如果当前节点右孩子不为空
        if (curNode.getLeft()!=null) {
            return queryMax(curNode.getLeft());
        }

        // 如果是左孩子，那么往上走(如果是走到了这一步就一定会有结果)
        Node pNode = curNode.getParent();
        while(pNode!=null && Objects.equals(pNode.left,curNode)){
            curNode = pNode;
            pNode = pNode.getParent();
        }
        return pNode;
    }

    /**
     * 交换两颗子树
     * @param originNode
     * @param replaceNode
     */
    public void transplant(Node originNode,Node replaceNode){

    }

    /**
     * 插入数据
     * @param i
     */
    public void insert(int i){

    }

    /**
     * 删除节点
     * @param i
     */
    public void delete(int i){

    }

    public int[] preSearch(){
        return null;
    }

    public int[] midSearch(){
        return null;
    }

    public int[] afterSearch(){
        return null;
    }

    public int[] depthSearch(){
        return null;
    }

    public int[] breadthSearch(){
        return null;
    }


    @Data
    private static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;
    }
}

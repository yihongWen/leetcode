package zyj.yihong.datastruct.link;

import lombok.Data;

import java.util.Arrays;

/**
 * @author yihong
 */
public class LinkList {

    /**
     * 链表表头引用
     */
    private LinkNode head;

    /**
     * 链表的大小
     */
    private int size = 0;

    public LinkList() {
    }

    /**
     * 构造：初始化链表
     * @param initData
     */
    public LinkList(int[] initData) {
        head = new LinkNode(initData[0]);
        LinkNode cur = head;
        size++;
        for (int i = 1; i < initData.length; i++) {
            LinkNode linkNode = new LinkNode(initData[i]);
            cur.setNext(linkNode);
            linkNode.setPre(cur);
            cur = linkNode;
            size++;
        }
    }

    /**
     * 添加数据 在指定位置
     * @param value
     */
    public void add(int value,int index){
        if (index<0 || index>size){
            throw new RuntimeException("插入位置不合法");
        }

        // 遍历到要插入的前一位、特殊处理
        if (index==0){
            LinkNode linkNode = new LinkNode(value);
            linkNode.setNext(head);
            head.setPre(linkNode);
            head = linkNode;
            return;
        }
        LinkNode cur = head;
        int curIndex = 0;
        while(cur!=null){
            if (curIndex == (index-1)){
                LinkNode linkNode = new LinkNode(value);
                LinkNode oldNext = cur.getNext();
                if(oldNext!=null){
                    oldNext.setPre(linkNode);
                }
                linkNode.setNext(oldNext);
                cur.setNext(linkNode);
                linkNode.setPre(cur);
                size++;
                return;
            }else {
                cur = cur.getNext();
                curIndex++;
            }
        }
    }


    /**
     * 移除某个节点
     * @param index
     */
    public void remove(int index){
        if (index<0 || index>size || size == 0 ){
            throw new RuntimeException("下标不合法、或者链表数据为空");
        }

        int curIndex = 0;
        LinkNode curNode = head;
        while(curNode!=null){
            if (curIndex == index){
                LinkNode pre = curNode.getPre();
                LinkNode next = curNode.getNext();

                if (pre==null){
                    // 删除
                    curNode.setNext(null);
                    head = next;
                    next.setPre(null);
                }else if (next==null){
                    pre.setNext(null);
                    curNode.setPre(null);
                }else {
                    curNode.setPre(null);
                    curNode.setNext(null);
                    pre.setNext(next);
                    next.setPre(pre);
                }
                size--;
            }

            curNode = curNode.getNext();
            curIndex++;
        }
    }


    /**
     * 打印数据
     */
    public void printf(){
        LinkNode curNode = head;
        int[] values = new int[size];
        int curIndex = 0;
        while(curNode!=null){
            values[curIndex] = curNode.getData();
            curNode = curNode.getNext();
            curIndex++;
        }
        System.out.println(Arrays.toString(values));
    }

    /**
     * 获取指定index的数据
     * @param index
     * @return
     */
    public int getIndexValue(int index){
        if (index<0 || index>=size){
            throw new RuntimeException("下标值不合法");
        }
        LinkNode curNode = head;
        int cur = 0;
        while (curNode!=null){
            if (cur!=index){
                curNode = curNode.getNext();
                cur++;
            }else {
                return curNode.getData();
            }
        }
        return 0;
    }

    public int getSize(){
        return size;
    }


    /**
     * 链表的节点：双向
     * @author yihong
     */
    @Data
    private static class LinkNode {
        private Integer data;

        private LinkNode pre;

        private LinkNode next;

        public LinkNode(Integer data) {
            this.data = data;
        }
    }
}

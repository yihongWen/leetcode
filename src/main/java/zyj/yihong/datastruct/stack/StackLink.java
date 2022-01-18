package zyj.yihong.datastruct.stack;

import zyj.yihong.datastruct.link.LinkList;

/**
 * 基于链表实现栈
 */
public class StackLink {
    /**
     * 栈的大小
     */
    private int stackSize;

    /**
     * 当前的栈大小
     */
    private int curStackSize;

    /**
     * 链表
     */
    private LinkList linkList;

    public StackLink(int stackSize) {
        this.stackSize = stackSize;
        this.curStackSize = 0;

    }

    /**
     * 压栈
     * @param i
     */
    public void push(int i){
        if (curStackSize==stackSize){
            throw new RuntimeException("当前栈已经满了");
        }
        if (linkList==null){
            int[] init = {i};
            this.linkList = new LinkList(init);
        }else {
            linkList.add(i,curStackSize);
        }
        curStackSize++;
    }

    /**
     * 出栈
     * @return
     */
    public void pop(){
        if (curStackSize==0){
            throw new RuntimeException("当前栈为空");
        }

        linkList.remove(curStackSize-1);
        curStackSize--;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int top(){
        return linkList.getIndexValue(curStackSize-1);
    }
}

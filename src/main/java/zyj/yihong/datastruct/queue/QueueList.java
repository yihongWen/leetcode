package zyj.yihong.datastruct.queue;

import zyj.yihong.datastruct.link.LinkList;

public class QueueList {
    private int queueSize;

    private int curQueueSize = 0;

    private LinkList linkList;

    public QueueList(int queueSize) {
        this.queueSize = queueSize;
    }

    public void add(int value){
        if (queueSize==curQueueSize){
            throw new RuntimeException("队列已满");
        }
        if (linkList==null){
            int[] init = {value};
            this.linkList = new LinkList(init);
        }else {
            linkList.add(value,curQueueSize);
        }
        linkList.add(value,curQueueSize);
        curQueueSize++;
    }

    public int poll(){
        if (queueSize==0){
            throw new RuntimeException("队列为空");
        }
        int indexValue = linkList.getIndexValue(0);
        linkList.remove(0);
        return indexValue;
    }

    public int peek(){
        if (queueSize==0){
            throw new RuntimeException("队列为空");
        }
        int indexValue = linkList.getIndexValue(0);
        return indexValue;
    }

}

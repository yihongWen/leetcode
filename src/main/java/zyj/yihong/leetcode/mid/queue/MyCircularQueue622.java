package zyj.yihong.leetcode.mid.queue;

import java.util.Arrays;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 *
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * 你的实现应该支持如下操作：
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyCircularQueue622 {
    int[] arrQueue;
    int headQueue;
    int tailQueue;
    int count;

    /**
     * 初始化一个大小为K的数组（队列）
     * @param k
     */
    public MyCircularQueue622(int k) {
        arrQueue = new int[k];
        headQueue = 0;
        tailQueue = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (arrQueue==null || count==arrQueue.length){
            return false;
        }
        arrQueue[tailQueue] = value;
        count++;
        tailQueue = (tailQueue+1)%arrQueue.length;
        return true;

    }

    public boolean deQueue() {
        if (arrQueue==null || count==0){
            return false;
        }
        count--;
        headQueue = (headQueue+1)%arrQueue.length;
        return true;
    }

    public int Front() {
        if (arrQueue==null || count==0){
            return -1;
        }
        int result = arrQueue[headQueue];
        return result;
    }

    public int Rear() {
        if (arrQueue==null || count==0){
            return -1;
        }
        int result = arrQueue[(tailQueue-1+arrQueue.length)%arrQueue.length];

        return result;
    }

    public boolean isEmpty() {
        if (arrQueue==null|| count==0){
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (arrQueue!=null&&count== arrQueue.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] testString = {"MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"};
        int[][] numArr = {{3},{1},{2},{3},{4},{},{},{},{4},{}};
        MyCircularQueue622 myCircularQueue622 = null;

        Object[] ret = new Object[numArr.length];
        for (int i = 0; i < testString.length; i++) {
            Object o = null;
            if (testString[i].equals("MyCircularQueue")){
                myCircularQueue622 = new MyCircularQueue622(numArr[i][0]);
            }else if (testString[i].equals("enQueue")){
                o = myCircularQueue622.enQueue(numArr[i][0]);

            }else if (testString[i].equals("deQueue")){
               o =  myCircularQueue622.deQueue();
            }else if (testString[i].equals("Front")){
                o = myCircularQueue622.Front();

            }else if (testString[i].equals("Rear")){
                o = myCircularQueue622.Rear();
            }else if (testString[i].equals("isEmpty")){
                o = myCircularQueue622.isEmpty();
            }else if (testString[i].equals("isFull")){
                o = myCircularQueue622.isFull();
            }
            ret[i] = o;
        }

        System.out.println(Arrays.toString(ret));
    }
}

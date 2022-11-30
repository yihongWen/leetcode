package zyj.yihong.leetcode.random_select.nov;

// 面试题 03.01. 三合一
public class TripleInOne_S_M0301 {
    int[] stack;
    int[] ptr = new int[3];
    int stackSize;

    public TripleInOne_S_M0301(int stackSize) {
        stack = new int[stackSize * 3];
        ptr[1] = stackSize;
        ptr[2] = 2 * stackSize;
        this.stackSize = stackSize;

    }

    public void push(int stackNum, int value) {
        if (ptr[stackNum] == (stackNum+1)*stackSize){
            return;
        }
        stack[ptr[stackNum]] = value;
        ptr[stackNum]++;
    }

    public int pop(int stackNum) {
        if (ptr[stackNum]==stackNum*stackSize){
            return -1;
        }
        return stack[--ptr[stackNum]];
    }

    public int peek(int stackNum) {
        if (ptr[stackNum]==stackNum*stackSize){
            return -1;
        }

        int pop = ptr[stackNum] - 1;
        return stack[pop];
    }

    public boolean isEmpty(int stackNum) {
        return ptr[stackNum]==stackNum*stackSize;
    }


    public static void main(String[] args) {
        TripleInOne_S_M0301 tripleInOne_s_m0301 = new TripleInOne_S_M0301(1);
        tripleInOne_s_m0301.push(0,1);
        tripleInOne_s_m0301.push(0,2);
        int p1 = tripleInOne_s_m0301.pop(0);
        int p2 = tripleInOne_s_m0301.pop(0);
        int p3 = tripleInOne_s_m0301.pop(0);
        boolean empty = tripleInOne_s_m0301.isEmpty(0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(empty);


//        ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
//        [null,null,null,1,-1,-1,true]


    }
}

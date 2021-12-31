package zyj.yihong.leetcode;

/**
 * 主要用于测试
 */
public class Test {
    public static void main(String[] args) {
        MyStack225 myStack225 = new MyStack225();
        System.out.println(myStack225.singleEmpty());

        myStack225.singlePush(16);
        myStack225.singlePush(89);
        myStack225.singlePush(66);

        System.out.println(myStack225.singleEmpty());
        System.out.println(myStack225.singlePop());
        System.out.println(myStack225.singleTop());
        System.out.println(myStack225.singleTop());

    }

}

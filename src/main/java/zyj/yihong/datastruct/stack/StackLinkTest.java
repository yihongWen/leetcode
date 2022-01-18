package zyj.yihong.datastruct.stack;

public class StackLinkTest {
    public static void main(String[] args) {
        StackLink stackLink = new StackLink(5);

        stackLink.push(1);
        stackLink.push(2);
        stackLink.push(3);
        stackLink.push(4);
        stackLink.push(5);

        System.out.println(stackLink.top());
        stackLink.pop();

        System.out.println(stackLink.top());
        stackLink.pop();

        System.out.println(stackLink.top());
        stackLink.pop();

        System.out.println(stackLink.top());
        stackLink.pop();
        System.out.println(stackLink.top());


    }
}

package zyj.yihong.datastruct.queue;

public class QueueTest {
    public static void main(String[] args) {
        QueueList queueList = new QueueList(5);
        for (int i = 0; i < 5; i++) {
            queueList.add(i);
        }

        System.out.println(queueList.poll());
        System.out.println(queueList.poll());
        System.out.println(queueList.poll());
        System.out.println(queueList.poll());
        System.out.println(queueList.poll());

    }
}

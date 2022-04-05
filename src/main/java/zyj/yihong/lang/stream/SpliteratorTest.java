package zyj.yihong.lang.stream;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SpliteratorTest {
    private static transient AtomicInteger sum = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arrList.add(i);
        }

        System.out.println("--------并行计算开始-----");
        Queue<Spliterator> queue = new ArrayDeque<>();
        Spliterator<Integer> spliterator = arrList.stream().spliterator();
        queue.add(spliterator);
        while (queue.peek().estimateSize()>200){
            Spliterator poll = queue.poll();
            Spliterator spliterator1 = poll.trySplit();
            queue.add(spliterator1);
            queue.add(poll);
        }

        List<Thread> threads = new ArrayList<>();
        long time1 = System.currentTimeMillis();
        while (!queue.isEmpty()){
            Spliterator poll = queue.poll();
            MyRunnable myRunnable = new MyRunnable(poll);
            Thread thread = new Thread(myRunnable);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(sum);
        long time2 = System.currentTimeMillis();
        System.out.println("------并行计算结束time："+(time2-time1));

        System.out.println("");

        System.out.println("------普通计算开始-----");
        long time3 = System.currentTimeMillis();
        sum.set(0);
        for (Integer num : arrList) {
            sum.addAndGet(num);
        }
        System.out.println(sum);
        long time4 = System.currentTimeMillis();
        System.out.println("------普通计算结束time："+(time4-time3));

        System.out.println();
        System.out.println("---------stream并行流开始------");
        long time5 = System.currentTimeMillis();
        Integer sum = arrList.stream().parallel().reduce(0, Integer::sum);
        long time6 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("---------stream并行流时间："+(time6-time5));


    }

    public static class MyRunnable implements Runnable{
        private Spliterator<Integer> spliterator;
        public MyRunnable(Spliterator spliterator) {
            this.spliterator = spliterator;
        }

        @Override
        public void run() {
            spliterator.forEachRemaining((a)->{
                sum.addAndGet(a);
            });
        }
    }
}

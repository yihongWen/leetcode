package zyj.yihong.lang.demo;

import java.util.ArrayList;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        FoodPool container = new FoodPool(new ArrayList<>());
        Thread t1 = new Thread(new ProducerThread(container));
        Thread t2 = new Thread(new ConsumerThread(container));
        t1.start();
        t2.start();
        Thread.currentThread().join();

    }
}

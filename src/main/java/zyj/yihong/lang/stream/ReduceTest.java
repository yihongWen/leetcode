package zyj.yihong.lang.stream;

import java.util.ArrayList;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        long time1 = System.currentTimeMillis();
        Integer sum = list.stream().reduce(0, (identity, b) -> {
            return identity + b;
        });
        long time2 = System.currentTimeMillis();
        System.out.println("普通计算时间："+(time2-time1)+ "结果："+sum);

        long time3 = System.currentTimeMillis();
        Integer parallelSum = list.parallelStream().reduce(0, (b, c) -> {
            return b + c;
        }, (a, b) -> {
            return a + b;
        });
        long time4 = System.currentTimeMillis();
        System.out.println("并行时间："+(time4-time3)+ "结果："+parallelSum);

    }

}

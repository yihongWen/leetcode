package zyj.yihong.lang.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int i1 = random.nextInt(20);
            numList.add(i1);
        }
        Stream<Integer> stream = numList.stream();
        Stream<Integer> filterStream = stream.filter((i) -> {
            return i > 3;
        });

        Stream<Integer> sortedStream = filterStream.sorted();

        Optional<Integer> first = sortedStream.findFirst();

        System.out.println(first.get());
    }
}

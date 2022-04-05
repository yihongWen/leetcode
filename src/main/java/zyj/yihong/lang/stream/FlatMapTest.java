package zyj.yihong.lang.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i, new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                list.get(i).add(i * 100 + j);
            }
        }

        List<Integer> map = list.stream().map(item -> {
            Integer a = 0;
            for (Integer integer : item) {
                a += integer;
            }
            return a;
        }).collect(Collectors.toList());

        System.out.println(map);
        List<Integer> collect = list.stream().flatMap(item -> {
            return item.stream();
        }).collect(Collectors.toList());
        System.out.println(collect);
    }


}

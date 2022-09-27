package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 791. 自定义字符串排序
public class CustomSortString_M_791 {
    public static String customSortString(String order, String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }

        Stream<Integer> sorted = s.chars().boxed().sorted((o1, o2) -> {
            int index1 = arr[o1 - 'a'];
            int index2 = arr[o2 - 'a'];
            if (index2 != -1 && index1 != -1) {
                return index1 - index2;
            }
            if (index1 == -1 && index2 == -1) {
                return 0;
            }

            if (index2 == -1) {
                return -1;
            }
            return 1;

        });
        List<Integer> collect = sorted.collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : collect) {
            char c = (char) (int) (i);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String order  = "cba";
        String s = "abcd";
        String s1 = customSortString(order, s);
        System.out.println(s1);
    }
}

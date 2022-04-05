package zyj.yihong.lang.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式
 */
public class LambdaTest {
    public static void main(String[] args) {
        Integer[] arr = {3,5,2,7,4};

        // 内部类
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };

        // 使用普通的方式:定义一个类，然后创建对象
        MyComparator myComparator = new MyComparator();
        Arrays.sort(arr,myComparator);

        // 使用内部类
        Arrays.sort(arr,integerComparator);

        // 匿名内部类
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

//         lambda表达式
        Arrays.sort(arr,(o1, o2) ->{
            return o1-o2;
        } );

        // 方法引用
        Arrays.sort(arr, Integer::compareTo);

    }

    public static class MyComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }



}

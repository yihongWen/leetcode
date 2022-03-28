package zyj.yihong.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<Long> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(System.currentTimeMillis()/(10+i));
        }

        Iterator<Long> iterator = intList.iterator();
        while (iterator.hasNext()){
            Long next = iterator.next();
            System.out.println(next);
        }
        System.out.println("----------");
    }
}

package zyj.yihong.design.jczh;

import pre4.combination.MyCombinationHashSet;
import pre4.inherit.MyInheritHashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yihong
 */
public class Client {
    public static void main(String[] args) {
        MyInheritHashSet<String> myInheritHashSet = new MyInheritHashSet<>();

        String s1 = "single_test1";
        String s2 = "single_test2";
        List<String> stringList = Arrays.asList("mul_test1", "mul_test2", "mul_test3");
        myInheritHashSet.add(s1);
        myInheritHashSet.add(s2);
        myInheritHashSet.addAll(stringList);
        System.out.println(myInheritHashSet.getCount());


        List<String> stringList1 = Arrays.asList("mul_test4", "mul_test5", "mul_test6");
        myInheritHashSet.myAddAll(stringList1);
        System.out.println(myInheritHashSet.getCount());

        MyCombinationHashSet<String> myCombinationHashSet = new MyCombinationHashSet<>(new HashSet<String>());
        myCombinationHashSet.add(s1);
        myCombinationHashSet.add(s2);
        myCombinationHashSet.addAll(stringList);
        System.out.println(myCombinationHashSet.getCount());
    }
}

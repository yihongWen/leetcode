package zyj.yihong.lang.stream;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest2 {
    public static void main(String[] args) {
        int temp = 10;
        int temp2 =20;
        List<String> test = new ArrayList<>();
        print((a)->{
            int i = temp+1;
            System.out.println(temp2);
            test.add("a");
            a++;
        },40);

        Method[] methods = LambdaTest2.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("------------------");
            System.out.println(method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getTypeName());
            }
        }
    }

    public static void print(Consumer<Integer> consumer, int a){
        System.out.println(consumer);
        consumer.accept(a);
    }

}

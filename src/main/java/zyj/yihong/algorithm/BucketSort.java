package zyj.yihong.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * bucket sort
 *
 * @author yihong
 */
public class BucketSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 找到最大值
        int maxValue = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > maxValue) {
                maxValue = i;
            }
        }

        int bucketSize = maxValue / 5;

        // 分桶分成6个桶,默认都是平均分配，不够在进行动态扩展
        int[][] bucket = new int[5 + 1][0];

        // 分桶
        for (int i : arr) {
            int index = i / bucketSize;
            index = Math.min(index, 5);
            bucket[index] = arrAppend(bucket[index], i);
        }

        // 将每个桶的数据进行排序

        int sortIndex = 0;
        for (int[] ints : bucket) {
            Arrays.sort(ints);
            for (int anInt : ints) {
                arr[sortIndex] = anInt;
                sortIndex++;
            }
        }
    }

    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 50; j++) {
            Random random = new Random();
            int[] testArr = new int[6];
            for (int i = 0; i < testArr.length; i++) {
                int i1 = random.nextInt(10);
                testArr[i] = i1;
            }
            System.out.println(Arrays.toString(testArr));
            sort(testArr);
            System.out.println(Arrays.toString(testArr));

        }

        int[] testArrays = {3, 6, 2, 5, 0, 1};
        sort(testArrays);

    }


}

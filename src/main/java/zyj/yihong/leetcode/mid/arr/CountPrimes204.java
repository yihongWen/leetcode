package zyj.yihong.leetcode.mid.arr;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            // 边界,当前值已经被标记过，不是素数
            if (arr[i]==0){
                continue;
            }

            // 是素数count++
            count++;

            // 往后标记
            if (i*i<n){
                for (long j = i*i; j <n ; j+=i) {
                    arr[(int)j]=0;
                }
            }
        }

        return count;
    }
}

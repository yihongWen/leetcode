package zyj.yihong.leetcode.random_select.nov;

import java.util.Arrays;

// 1860. 增长的内存泄露
public class MemLeak_M_1860 {
    public static int[] memLeak(int memory1, int memory2) {
        // 使用数学推导的方式：https://leetcode.cn/problems/incremental-memory-leak/solution/ji-nian-yi-xia-wo-kan-cuo-fu-za-du-dao-z-a6vh/
        boolean flag = false;
        if (memory1 < memory2) {
            flag = true;
        }
        long m1 = Math.max(memory1, memory2);
        long m2 = Math.min(memory1, memory2);

        // 计算出1-x 减少，此时m1>m2 当x+1时 m1<m2 计算出x
        int n = (int) (Math.sqrt(2 * (m1 - m2) + 0.25) - 0.5);
        m1 -= ((long)(1 + n) * (long)n) / 2;

        // 第一次交换过,m1 = mem2, 优先处理后，两者相等优先处理men1，此时相当于在交换依次
        if (flag&&m2==m1){
            flag = false;
        }

        // 进过减少x次之后，m1跟m2执行交替减少 假设减少的次数为a
        int a = (int) (Math.sqrt(m1 +  (((long)n * (long)n) / 4.0)) - n / 2.0);


        m1 -= (long)(n + a) * a;
        m2 -= (long)(n + a) * (a - 1);
        n += (a * 2) - 1;
        if (m2 >= n + 1) {
            n += 1;
            m2 -= n;
        }
        if (flag) {
            return new int[]{++n, (int)m2, (int)m1};
        }
        return new int[]{++n, (int)m1, (int)m2};
    }

    public static void main(String[] args) {
        int[] ints = memLeak(2044763854,
                741884016);
        System.out.println(Arrays.toString(ints));
    }
}

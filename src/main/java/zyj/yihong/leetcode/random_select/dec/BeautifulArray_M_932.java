package zyj.yihong.leetcode.random_select.dec;

import java.util.HashMap;
import java.util.Map;

// 932. 漂亮数组
public class BeautifulArray_M_932 {
    public int[] beautifulArray(int n) {
        Map<Integer, int[]> memory = new HashMap<>();
        int[] arr1 = {1};
        int[] arr2 = {1, 2};
        memory.put(1, arr1);
        memory.put(2, arr2);
        for (int i = 3; i <= n; i++) {
            // 处理部分
            int[] oddArr = memory.get((i + 1) / 2);
            int[] evenArr = memory.get(i/2);
            int[] genArr = new int[i];
            for (int j = 0; j < oddArr.length; j++) {
                genArr[j] = oddArr[j]*2-1;
            }
            for (int j = 0; j < evenArr.length; j++) {
                genArr[oddArr.length+j] = evenArr[j]*2;
            }
            memory.put(i,genArr);
        }
        return memory.get(n);

    }
}

package zyj.yihong.leetcode.random_select.dec;

import java.util.HashMap;
import java.util.Map;

// 1442. 形成两个异或相等数组的三元组数目
public class CountTriplets_M_1442 {
    public int countTriplets(int[] arr) {
        int[] preXorSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            preXorSum[i + 1] = preXorSum[i] ^ arr[i];
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (preXorSum[i] == preXorSum[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }


    public int countTripletsForCache(int[] arr) {
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int preXorSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (countMap.containsKey(preXorSum^num)){
                ans+=countMap.get(preXorSum^num)*i-sumMap.get(preXorSum^num);
            }
            countMap.put(preXorSum,countMap.getOrDefault(preXorSum,0)+1);
            sumMap.put(preXorSum,sumMap.getOrDefault(preXorSum,0)+i);
            preXorSum = preXorSum^num;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 7};
        CountTriplets_M_1442 countTriplets_m_1442 = new CountTriplets_M_1442();
        int i = countTriplets_m_1442.countTripletsForCache(arr);
        System.out.println(i);
    }
}

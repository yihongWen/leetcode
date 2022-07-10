package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.Arrays;

/**
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 *
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 *
 * 并返回一个包含给定查询 queries 所有结果的数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xor-queries-of-a-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class XorQueries_M_1310 {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        // 异或前缀和
        int[] xorPreSum = new int[arr.length];
        xorPreSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xorPreSum[i] = xorPreSum[i-1]^arr[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            if (left!=0) {
                ans[i] = xorPreSum[right] ^ xorPreSum[left - 1];
                continue;
            }
            ans[i] = xorPreSum[right];
        }

        return ans;
    }

    public static void main(String[] args) {
//        输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
        int[] arr ={1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int[] ints = xorQueries(arr, queries);
        System.out.println(Arrays.toString(ints));
    }
}

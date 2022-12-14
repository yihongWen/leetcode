package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 1409. 查询带键的排列
public class ProcessQueries_M_1409 {
    public int[] processQueries(int[] queries, int m) {
        // 使用模拟的方式
        int[] ans = new int[queries.length];
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int num = queries[i];
            int index = 0;
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (list.get(i1) == num) {
                    index = i1;
                    break;
                }
            }
            ans[i] = index;
            list.remove(index);
            list.add(0, num);
        }

        return ans;
    }


    // 使用树状数组
    public int[] processQueries2(int[] queries, int m) {
        int n = queries.length;


        // 用于保存当前数字（数组的下标），所在树状数组的index
        int[] tempHandelPos = new int[m + 1];

        // 初始化树状数组
        FenwickTree fenwickTree = new FenwickTree(m + n);
        for (int i = 1; i <= m; i++) {
            fenwickTree.add(n + i, 1);
            tempHandelPos[i] = n + i;
        }

        int[] ansArr = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int fenwickTreeIndex = tempHandelPos[query];
            int ans = fenwickTree.query(fenwickTreeIndex - 1);
            ansArr[i] = ans;

            fenwickTree.add(fenwickTreeIndex, -1);
            fenwickTree.add(n - i, 1);
            tempHandelPos[query] = n - i;

        }

        return ansArr;

    }


    public static class FenwickTree {
        private int[] arr;
        private int size;

        public FenwickTree(int size) {
            this.size = size;
            this.arr = new int[size + 1];
        }

        private int lowbit(int x) {
            return x & (-x);
        }

        public int query(int index) {
            int ans = 0;
            ans += arr[index];
            int curIndex = index;
            while (curIndex > 0) {
                curIndex = curIndex - lowbit(curIndex);
                ans += arr[curIndex];
            }
            return ans;
        }

        public void add(int index, int v) {
            arr[index] += v;
            int curIndex = index;
            while (true) {
                curIndex = curIndex + lowbit(curIndex);
                if (curIndex <= size) {
                    arr[curIndex] += v;
                    continue;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] queries = {3, 1,2,1};
        int m = 5;
        ProcessQueries_M_1409 processQueries_m_1409 = new ProcessQueries_M_1409();
        int[] ans = processQueries_m_1409.processQueries2(queries, m);
        System.out.println(Arrays.toString(ans));
    }
}

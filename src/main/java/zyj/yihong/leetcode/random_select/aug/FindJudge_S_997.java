package zyj.yihong.leetcode.random_select.aug;

// 997. 找到小镇的法官
public class FindJudge_S_997 {
    public static int findJudge(int n, int[][] trust) {
        int[] arr = new int[n];
        for (int i = 0; i < trust.length; i++) {
            int[] curNode = trust[i];
            int i1 = curNode[0];
            arr[i1 - 1] -= n;
            arr[curNode[1]-1] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] arr = {{1, 3}, {2, 3}};
        int judge = findJudge(n, arr);
        System.out.println(judge);

    }
}

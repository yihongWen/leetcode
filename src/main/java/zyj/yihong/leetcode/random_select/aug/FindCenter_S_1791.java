package zyj.yihong.leetcode.random_select.aug;


// 1791. 找出星型图的中心节点
public class FindCenter_S_1791 {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length+1];
        for (int[] edge : edges) {
            arr[edge[0]-1]++;
            arr[edge[1]-1]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==edges.length){
                return i+1;
            }
        }
        return -1;
    }


}

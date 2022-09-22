package zyj.yihong.leetcode.random_select.seg;

import java.util.HashMap;
import java.util.Map;

// 1640. 能否连接形成数组
public class CanFormArray_S_1640 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,Integer> recordIndexMap = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            recordIndexMap.put(pieces[i][0],i);
        }

        int i = 0;
        while (i< arr.length){
            int num = arr[i];
            Integer index = recordIndexMap.get(num);
            if (index==null){
                return false;
            }
            int[] piece = pieces[index];
            for (int j = 0; j < piece.length; j++) {
                if (piece[j]==arr[i]){
                    i++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {49,18,16};
        int[][] pieces = {{16,18,49}};
        boolean b = canFormArray(arr, pieces);
        System.out.println(b);
    }
}

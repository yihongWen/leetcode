package zyj.yihong.leetcode.random_select.seg;


import java.util.HashMap;
import java.util.Map;

// 697. 数组的度
public class FindShortestSubArray_S_697 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num)){
                int[] node = map.get(num);
                node[0]++;
                node[2]=i;
            }else {
                map.put(num,new int[]{1,i,i});
            }
        }

        int[] curAns = map.get(nums[0]);
        for (Integer key : map.keySet()) {
            int[] node = map.get(key);
            if (node[0]>curAns[0]){
                curAns = node;
            }else if (node[0]==curAns[0]){
                if (curAns[2]-curAns[1]-(node[2]-node[1])>=0){
                    curAns = node;
                }
            }
        }
     return curAns[2]-curAns[1]+1;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        int shortestSubArray = findShortestSubArray(arr);
        System.out.println(shortestSubArray);

    }
}

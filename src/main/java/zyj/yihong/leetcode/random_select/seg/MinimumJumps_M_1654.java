package zyj.yihong.leetcode.random_select.seg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 1654. 到家的最少跳跃次数
public class MinimumJumps_M_1654 {
    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        int fMax = forbidden[0];
        Set<Integer> set = new HashSet<>();
        for (int f : forbidden) {
            fMax = Math.max(f,fMax);
            set.add(f);
        }

        fMax = Math.max(fMax+a+b,x+b);


        boolean[][] flag = new boolean[fMax+1][2];
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (queue.size()!=0){
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] info = queue.poll();

                if (info[0]==x){
                    return ans;
                }

                if (flag[info[0]][info[1]]){
                    continue;
                }

                flag[info[0]][info[1]]=true;

                if (info[0]+a<=fMax && !set.contains(info[0]+a)){
                    queue.add(new int[]{info[0]+a,0});
                }

                if (info[0]-b>=0 && !set.contains(info[0]-b) && info[1]<1){
                    queue.add(new int[]{info[0]-b,info[1]+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,16,3,2,13,7,9};
        int a = 11;
        int b = 6;
        int x = 6;

        int i = minimumJumps(arr, a, b, x);
        System.out.println(i);
    }
}

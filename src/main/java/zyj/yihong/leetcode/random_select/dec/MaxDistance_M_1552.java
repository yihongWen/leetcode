package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;

// 1552. 两球之间的磁力
public class MaxDistance_M_1552 {
    // 贪心+二分查找
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length-1]-position[0];
        int ans = 0;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (check(mid,position,m)){
                left = mid+1;
                ans = mid;
            }else {
                right = mid-1;
            }
        }
        return ans;
    }

    private boolean check(int x,int[] positions,int m){
        int count =1;
        int pre = 0;
        for (int i = 1; i < m; i++) {
            for (int i1 = pre+1; i1 < positions.length; i1++) {
                if (positions[i1]-positions[pre]>=x){
                    pre = i1;
                    count++;
                    break;
                }
            }
            if (count!=i+1){
                return false;
            }
        }
        return true;
    }
}

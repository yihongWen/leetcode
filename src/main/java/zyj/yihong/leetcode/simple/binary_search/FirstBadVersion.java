package zyj.yihong.leetcode.simple.binary_search;

public class FirstBadVersion {
    private boolean[] flag;

    public int firstBadVersion(int n) {
        flag = new boolean[n+1];
        int bad = 1;
        for (int i = bad; i <= n; i++) {
            flag[i] = true;
        }
        int left = 1;
        int right = n;
        while (left<right){
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)){
                right = mid;
                continue;
            }
            left = mid+1;
        }

        return right;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int i = firstBadVersion.firstBadVersion(3);
        System.out.println(i);
    }


    boolean isBadVersion(int version){
        return flag[version];
    }
}

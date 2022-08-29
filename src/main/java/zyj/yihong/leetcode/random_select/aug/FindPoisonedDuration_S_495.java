package zyj.yihong.leetcode.random_select.aug;

// 495. 提莫攻击
public class FindPoisonedDuration_S_495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int curEnd = 0;
        for (int timeSery : timeSeries) {
            if (timeSery>curEnd){
                ans+= duration;
            }else {
                ans+= timeSery+duration-curEnd;
            }

            curEnd = timeSery+duration;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        int poisonedDuration = findPoisonedDuration(arr, 2);
        System.out.println(poisonedDuration);
    }
}

package zyj.yihong.leetcode.mid.binary_search;

/**
 *
 */
public class FindNthDigit400 {
    public int findNthDigit(int n) {
        // 根据规律找到ans的位数
        int left = 1;
        int right = 9;
        while (left<right){
            int mid = (right-left)/2+left;
            if (cal(mid)<n){
                left = mid+1;
            }else {
                right = mid;
            }
        }

        int digitLength = left;

        // 计算前一位的总数
        int preCount = cal(digitLength - 1);
        int index = n-preCount-1;

        // 计算digitLength位数的第一位数：
        int startNum = (int)Math.pow(10, digitLength - 1);

        int ansNum = startNum+index/digitLength;

        // 计算是ansNum中的哪一位
        int i = index % digitLength;
        return (ansNum / (int) (Math.pow(10, digitLength - i - 1))) % 10;
    }

    //计算从1位到length位包含的值
    private int cal(int length){
        int factor1 = 9;
        int cur = 1;
        int ans = 0;
        while (cur<=length){
            ans+=cur*factor1;
            factor1 = factor1*10;
            cur++;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindNthDigit400 findNthDigit400 = new FindNthDigit400();
        int nthDigit = findNthDigit400.findNthDigit(11);
        System.out.println(nthDigit);
    }
}

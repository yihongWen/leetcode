package zyj.yihong.leetcode.random_select.nov;

// 1680. 连接连续二进制数字
public class ConcatenatedBinary_M_1680 {
    public static int concatenatedBinary(int n) {
        int mod = 1000_000_000+7;
        int shift = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((i&(i-1))==0){
                shift++;
            }
            ans=(int) (((((long) ans <<shift))+i)%mod);
        }

        return ans;
    }

    public static void main(String[] args) {
        int a = concatenatedBinary(12);
        System.out.println(a);
    }
}

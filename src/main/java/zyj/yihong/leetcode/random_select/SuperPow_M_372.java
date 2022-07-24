package zyj.yihong.leetcode.random_select;

/**
 * 372. 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 */
public class SuperPow_M_372 {
    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length-1; i >=0 ; i--) {
            ans =(int)((long)ans * pow(a, b[i]) % 1337);
            a = pow(a,10);
        }

        return ans;
    }

    private int pow(int a,int n){
        // 快速幂
        int ans = 1;
        while (n!=0){
            if ((n&1)!=0){
                // 需要贡献
                ans = (int) ((long)ans*a)%1337;
            }
            a = (int)(((long)a*a)%1337);
            n=n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SuperPow_M_372 superPow_m_372 = new SuperPow_M_372();
//        2147483647
//[2,0,0]
        int[] arr = {2,0,0};
        int i = superPow_m_372.superPow(2147483647, arr);
        System.out.println(i);
    }
}

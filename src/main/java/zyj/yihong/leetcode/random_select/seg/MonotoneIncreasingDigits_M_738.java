package zyj.yihong.leetcode.random_select.seg;

// 738. 单调递增的数字
public class MonotoneIncreasingDigits_M_738 {
    public static int monotoneIncreasingDigits(int n) {
        StringBuilder s = new StringBuilder(String.valueOf(n));
        if (s.length()==1){
            return n;
        }

        int rIndex = -1;
        for (int i = 1; i < s.length() ; i++) {
            if (s.charAt(i)-s.charAt(i-1)<0){
                rIndex = i;
                break;
            }
        }

        // 如果不存在逆序对
        if (rIndex==-1){
            return n;
        }


        char cur = s.charAt(rIndex-1);
        for (int i = rIndex-1; i >=0 ; i--) {
            if (s.charAt(i)==cur){
                s.setCharAt(i,(char)(s.charAt(i)-1));
                s.setCharAt(i+1,'9');
            }
        }
        for (int i = rIndex; i < s.length(); i++) {
            s.setCharAt(i,'9');
        }

        return Integer.parseInt(s.toString());
    }

    public static void main(String[] args) {
        int ans = monotoneIncreasingDigits(332);
        System.out.println(ans);
    }
}

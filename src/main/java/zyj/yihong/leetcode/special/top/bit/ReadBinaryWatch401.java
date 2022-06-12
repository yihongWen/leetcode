package zyj.yihong.leetcode.special.top.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 */
public class ReadBinaryWatch401 {
    public static List<String> readBinaryWatch(int turnedOn) {
        // 二进制枚举：一共可能存在10位数，枚举2的10次方 1024
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <=1024 ; i++) {
            int h = i>>6;
            int m = i&((1<<6)-1);

            // 校验h、m是否满足需求
            if (h<12&&m<60&&Integer.bitCount(i)==turnedOn){
                String s = h + ":" + (m < 10 ? "0" : "") + m;
                ans.add(s);
            }
        }
        return ans;
    }

    public static int bitwiseComplement(int n) {
        // 找到最高位的1
        int maxLength = 0;

        // 由于n是整数，第31位一定为0
        for (int i = 1; i <=30 ; i++) {
        // 101 >100、 100==100
            if (n>=(1<<i)){
                maxLength = i;
                continue;
            }
            break;
        }

        return (~n)&((1<<(maxLength+1))-1);
    }

    public static void main(String[] args) {
        int i = bitwiseComplement(5);
        System.out.println(i);
    }
}

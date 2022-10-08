package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 面试题 01.09. 字符串轮转
public class IsFlipedString_S_M0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s2.length()>s1.length()){
            return false;
        }
//        特使处理
        if(s1.equals("") && s2.equals("")){
            return true;
        }

        if(s1.equals("") || s2.equals("")){
            return false;
        }

        String s = s1+s1;
        return kmp(s, s2);
    }

    public boolean kmp(String s1,String s2){
        int[] preLength = calKmpPreLengthArr(s2);
        int len1 = s1.length();
        int len2 = s2.length();

        int preIndex = -1;
        for (int i = 0; i < len1; i++) {
            // 不匹配
            while (preIndex!=-1 && s2.charAt(preIndex+1)!=s1.charAt(i)){
                preIndex = preLength[preIndex];
            }

            // 匹配
            if (s1.charAt(i)==s2.charAt(preIndex+1)){
                preIndex++;
            }

            if (preIndex==len2-1){
                return true;
            }
        }

        return false;
    }


    private int[] calKmpPreLengthArr(String s) {
        int[] preLengthArr = new int[s.length()];
        Arrays.fill(preLengthArr, -1);

        int preIndex = -1;
        for (int i = 1; i < s.length(); i++) {

            while (preIndex != -1 && s.charAt(preIndex + 1) != s.charAt(i)) {
                preIndex = preLengthArr[preIndex];
            }

            if (s.charAt(preIndex + 1) == s.charAt(i)) {
                preIndex++;
            }

            preLengthArr[i] = preIndex;
        }
        return preLengthArr;
    }

    public static void main(String[] args) {
        IsFlipedString_S_M0109 isFlipedString_s_m0109 = new IsFlipedString_S_M0109();
        boolean kmp = isFlipedString_s_m0109.isFlipedString("rxOpSEXvfIuoRJfjwgwuomevMMBOfeSMvYSPBaovrZBSgmCrSLDirNnILhARNShOYIFBHIRiFKHtfxWHjawaLRAEYPIZokUKgiqyZpvcOHdfPpRqHADKAXzEfzhxdXXb", "");
        System.out.println(kmp);

    }
}

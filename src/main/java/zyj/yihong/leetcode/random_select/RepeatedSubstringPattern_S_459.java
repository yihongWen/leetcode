package zyj.yihong.leetcode.random_select;

import java.util.Arrays;

/**
 * 459. 重复的子字符串
 */
public class RepeatedSubstringPattern_S_459 {
    public boolean repeatedSubstringPattern(String s) {
        int mid = s.length() >> 1;
        for (int i = 1; i <= mid; i++) {
            if (s.length()%i!=0){
                continue;
            }
            String substring = s.substring(0, 1);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < s.length() / i; j++) {
                stringBuilder.append(substring);
            }

            if (stringBuilder.toString().equals(s)){
                return true;
            }
        }
        return false;
    }


    public boolean repeatedSubstringPattern1(String s) {
        s = "aaddabcdda";
        int abc = s.indexOf("abc", 1);
        System.out.println(abc);
        return true;
    }


    public boolean kmp(String t,String p){
         // 计算前缀数组
        int[] prefixArr = calKmpPrefixArr(p);

        // 字符串匹配
        int len = t.length();
        int pLen = p.length();
        int handleIndex = -1;
        for (int i = 0; i < len; i++) {

            // 不想等的情况下，往前面移动
            while (handleIndex>=0&&t.charAt(i)!=p.charAt(handleIndex+1)){
                handleIndex = prefixArr[handleIndex];
            }


            // 当前相等的情况
            if (t.charAt(i)==p.charAt(handleIndex+1)){
                handleIndex++;
            }

            if (handleIndex+1==pLen){
                return true;
            }
        }
        return false;
    }

    public int[] calKmpPrefixArr(String s){
        // 计算kmp的前缀数组
        int[] prefixArr = new int[s.length()];
        Arrays.fill(prefixArr,-1);

        int handleIndex = -1;
        for (int i = 1; i < s.length(); i++) {

            // 当不符合匹配的情况
            while (handleIndex>=0&&s.charAt(i)!=s.charAt(handleIndex+1)){
                handleIndex=prefixArr[handleIndex];
            }

            // 当前符合匹配
            if (s.charAt(i)==s.charAt(handleIndex+1)){
                handleIndex++;
            }
            prefixArr[i] = handleIndex;
        }
        return prefixArr;
    }

    public static void main(String[] args) {
        String s  = "abcd";
        RepeatedSubstringPattern_S_459 repeatedSubstringPattern_s_459 = new RepeatedSubstringPattern_S_459();
        boolean kmp = repeatedSubstringPattern_s_459.kmp(s+s, s);
        System.out.println(kmp);
    }
}

package zyj.yihong.leetcode.random_select.dec;

// 1249. 移除无效的括号
public class MinRemoveToMakeValid_M_1249 {
    public String minRemoveToMakeValid(String s) {
        int[] arr = new int[s.length()];
        int signSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(') {
                signSize++;
            }else if (c==')') {
                if (signSize==0){
                    arr[i] = -1;
                }else {
                    signSize--;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)=='(' && signSize>0){
                signSize--;
                continue;
            }
            if (arr[i]==-1){
                continue;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.reverse().toString();
    }
}

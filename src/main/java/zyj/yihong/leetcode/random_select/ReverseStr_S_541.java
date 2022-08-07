package zyj.yihong.leetcode.random_select;

public class ReverseStr_S_541 {
    public String reverseStr(String s, int k) {
        int length = s.length();
        int count = length / (k << 1);
        int remand = length % (k << 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(new StringBuilder(s.substring(2*k*i,2*k*i+k)).reverse());
            stringBuilder.append(s, 2*k*i+k, 2*k*(i+1));
        }

        if (remand!=0&&remand<=k){
            stringBuilder.append(new StringBuilder(s.substring(2*k*count)).reverse());
        }else if (remand != 0){
            stringBuilder.append(new StringBuilder(s.substring(2*k*count,2*k*count+k)).reverse());
            stringBuilder.append(s.substring(2*k*count+k));
        }

        return stringBuilder.toString();
    }
}

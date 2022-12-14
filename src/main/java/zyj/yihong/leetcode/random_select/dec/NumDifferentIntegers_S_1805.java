package zyj.yihong.leetcode.random_select.dec;

import java.util.HashSet;
import java.util.Set;

// 1805. 字符串中不同整数的数目
public class NumDifferentIntegers_S_1805 {
    public static int numDifferentIntegers(String word) {
        StringBuilder num = new StringBuilder();
        Set<String> set = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c-'0'>=0&&c-'0'<=9){
                if (flag){
                    num = new StringBuilder();
                    flag = false;
                }
                if (c=='0'){
                    if (num.length()==0 || num.charAt(num.length()-1)!='0'){
                        num.append(c);
                    }
                }else {
                    if (num.length()==1 && num.charAt(0)=='0'){
                        num.deleteCharAt(num.length()-1);
                    }
                    num.append(c);
                }

                continue;
            }

            if (c-'a'>=0 && c-'a'<26){
                if (!flag){
                    flag = true;
                    set.add(num.toString());
                }
            }
        }
        if (!flag){
            set.add(num.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String word =  "au35cf7c305";
        int ans = numDifferentIntegers(word);
        System.out.println(ans);

    }
}

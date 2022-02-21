package zyj.yihong.leetcode.mid.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 */
public class FindLongestWord524 {

    /**
     * 使用排序+双指针的方式
     * @param s
     * @param dictionary
     * @return
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            // 先比较字符的长度
            if (o1.length()!=o2.length()){
              return o2.length()-o1.length();
            } else{
                // 比较字母顺序
                return o1.compareTo(o2);
            }
        });

        // 使用双指针的方式：
        for (String s1 : dictionary) {
            int i = 0;
            int j = 0;
            while (i<s.length()&&j<s1.length()){
                if (s.charAt(i)==s1.charAt(j)){
                    i++;
                    j++;
                }else {
                    i++;
                }
            }
            if (j==s1.length()){
                return s1;
            }
        }
        return "";
    }

    public static String findLongestWordByDp(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            // 先比较字符的长度
            if (o1.length()!=o2.length()){
                return o2.length()-o1.length();
            } else{
                // 比较字母顺序
                return o1.compareTo(o2);
            }
        });

        // 定义和构造dp数组
        int oriLength = s.length();
        int[][] dpArr =new int[oriLength+1][26];
        Arrays.fill(dpArr[oriLength],Integer.MIN_VALUE);

        // 逆向构造dp
        for (int i = oriLength-1; i >=0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i)-'a' ==j){
                    dpArr[i][j] = i;
                }else {
                    dpArr[i][j] = dpArr[i+1][j];
                }
            }
        }

        // 查找最佳
        for (String s1 : dictionary) {
            int start = 0;
            boolean match = true;
            for (int i = 0; i <s1.length() ; i++) {
                // 如果超出边界，则遍历下一个
                if (dpArr[start][s1.charAt(i)-'a']==Integer.MIN_VALUE){
                    match = false;
                    break;
                }else {
                    start = dpArr[start][s1.charAt(i) - 'a'] + 1;
                }
            }

            if (match){
                return s1;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");
        String longestWord = findLongestWordByDp(s, dictionary);
        System.out.println(longestWord);
    }
}

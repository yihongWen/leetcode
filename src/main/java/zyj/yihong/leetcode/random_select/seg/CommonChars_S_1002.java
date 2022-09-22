package zyj.yihong.leetcode.random_select.seg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars_S_1002 {
    public static List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] record = new int[26];
        Arrays.fill(record,Integer.MAX_VALUE);
        int[] replace = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                replace[c-'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (record[i]>replace[i]){
                    record[i] = replace[i];
                }
                replace[i] = 0;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < record[i]&&record[i]!=Integer.MAX_VALUE; j++) {
                ans.add(String.valueOf(((char) ('a'+i))));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        List<String> strings = commonChars(words);
        System.out.println(strings);

    }
}

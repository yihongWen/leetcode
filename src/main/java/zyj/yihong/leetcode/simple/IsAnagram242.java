package zyj.yihong.leetcode.simple;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class IsAnagram242 {
    /**
     * 使用类似于计数排序的思路
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s==null || t==null || s.length()!=t.length()){
            return false;
        }
        int[] alphabetArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabetArr[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabetArr[t.charAt(i)-'a']--;
        }

        for (int i : alphabetArr) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t ="car";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);

    }
}

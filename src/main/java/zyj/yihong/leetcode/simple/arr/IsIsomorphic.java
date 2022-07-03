package zyj.yihong.leetcode.simple.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        // 满足双映射的关系即可
        char[] s2t  = new char[256];
        char[] t2s = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            char v1 = s2t[cs];
            char v2 = t2s[ct];
            if ((v1!=0&&v1!=ct+1)||(v2!=0&&v2!=cs+1)){
                return false;
            }

            s2t[cs] = (char) (ct+1);
            t2s[ct] = (char) (cs+1);


        }

        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> patternToS = new HashMap<>();
        Map<String,Character> sToPattern = new HashMap<>();

        String[] split = s.split(" ");
        int length = pattern.length();
        if (split.length!=length){
            return false;
        }

        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            char c = pattern.charAt(i);
            if (patternToS.containsKey(c)&&!patternToS.get(c).equals(s1)){
                return false;
            }

            if (sToPattern.containsKey(s1)&&!sToPattern.get(s1).equals(c)){
                return false;
            }

            sToPattern.put(s1,c);
            patternToS.put(c,s1);
        }
        return true;
    }

    public static void main(String[] args) {
        String p = "abba";
        String s = "dog cat cat dog";
        boolean isomorphic = wordPattern(p,s);
        System.out.println(isomorphic);
    }

}

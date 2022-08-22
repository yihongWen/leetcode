package zyj.yihong.leetcode.random_select.aug;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 451. 根据字符出现频率排序
public class FrequencySort_M_451 {
    public static String frequencySort(String s) {
        Character[] chars = new Character[s.length()];
        int index = 0;
        for (char c : s.toCharArray()) {
            chars[index] = c;
            index++;
        }
        Map<Character,Integer> map = new HashMap<>();

        for (char aChar : chars) {
            map.put(aChar,map.getOrDefault(aChar,0)+1);
        }

        Arrays.sort(chars,(o1,o2)->{
            if (map.get(o2)-map.get(o1)==0){
                return o1-o2;
            }
            return map.get(o2)-map.get(o1);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (Character aChar : chars) {
            stringBuilder.append(aChar);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        String s1 = frequencySort(s);
        System.out.println(s1);
    }
}

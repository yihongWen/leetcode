package zyj.yihong.leetcode.mid.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 */
public class FindRepeatedDnaSequences187 {
    /**
     * 滑动窗口+位运算
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if ( s==null|| s.length()<=10){
            return result;
        }
        int[] sIntArr = new int[s.length()];
        for (int i = 0; i < sIntArr.length; i++) {
            char c = s.charAt(i);
            if (c=='A'){
                sIntArr[i]=0;
            }else if (c=='C'){
                sIntArr[i] = 1;
            }else if (c=='G'){
                sIntArr[i] = 2;
            }else if (c=='T'){
                sIntArr[i] = 3;
            }
        }

        Map<Integer,Integer> sequenceCount = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < 10; i++) {
            cur = (cur<<2)|sIntArr[i];
        }
        sequenceCount.put(cur,1);

        for (int i = 10; i < sIntArr.length; i++) {
            cur = ((cur << 2) | sIntArr[i]) & ((1<<20)-1);
            sequenceCount.put(cur,sequenceCount.getOrDefault(cur,0)+1);
            Integer count = sequenceCount.get(cur);
            if (count==2){
                result.add(s.substring(i-10+1,i+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);
    }
}

package zyj.yihong.leetcode.simple.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 720. 词典中最长的单词
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWord720 {
    /**
     * 排序、set
     * @param words
     * @return
     */
    public static String longestWord(String[] words) {
        // 排序、根绝长度，然后在根据字典序排序
        Arrays.sort(words,((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o2.compareTo(o1);
        }));

        Set<String> set = new HashSet<>();
        String resultString = null;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length()==1 || set.contains(word.substring(0, word.length()-1))){
                resultString = word;
                set.add(word);
            }
        }

        return resultString;
    }

    public static void main(String[] args) {
        String[] arr = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        String s = longestWord(arr);
        System.out.println(s);
    }
}

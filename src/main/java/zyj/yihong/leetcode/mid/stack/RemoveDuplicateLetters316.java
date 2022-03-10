package zyj.yihong.leetcode.mid.stack;

import java.util.Stack;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 */
public class RemoveDuplicateLetters316 {

    /**
     * 单调栈
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] charNum = new int[26];
        boolean[] charInStack = new boolean[26];

        // 计算某个字符存在的个数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charNum[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charInStack[c - 'a']) {
                charNum[c-'a']--;
                continue;
            }

            while (stack.size() != 0) {
                Character peek = stack.peek();
                if (c - peek < 0 && charNum[peek - 'a'] != 0) {
                    stack.pop();
                    charInStack[peek - 'a'] = false;
                    continue;
                }
                break;
            }
            stack.push(c);
            charInStack[c - 'a'] = true;
            charNum[c - 'a']--;

        }
        StringBuilder stringBuilder = new StringBuilder(stack.size());
        while (stack.size() != 0) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bbcaac";
        String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
    }
}

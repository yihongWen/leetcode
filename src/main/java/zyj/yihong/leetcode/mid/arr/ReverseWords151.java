package zyj.yihong.leetcode.mid.arr;

import java.util.Stack;

/**
 * 151. 颠倒字符串中的单词
 */
public class ReverseWords151 {
    public static String reverseWords(String s) {
        Stack<String> wordStack = new Stack<>();
        StringBuilder curWord = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                if (flag) {
                    wordStack.add(curWord.toString());
                    curWord.setLength(0);
                    flag = false;
                }
                continue;
            }
            curWord.append(s.charAt(i));
            flag = true;
        }

        if (!curWord.toString().equals("")){
            wordStack.add(curWord.toString());
            curWord.setLength(0);
        }

        if (wordStack.isEmpty()){
            return "";
        }

        while (!wordStack.isEmpty()){
            curWord.append(wordStack.pop());
            curWord.append(" ");
        }


        return curWord.deleteCharAt(curWord.length()-1).toString();
    }

    public static void main(String[] args) {
        String s = "the sky is   blue";
        String s1 = reverseWords(s);
        System.out.println(s1);

    }
}

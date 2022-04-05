package zyj.yihong.leetcode.mid.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString394 {

    public static String decodeString(String s) {
        // 定义栈
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int curIndex = 0;
        while (curIndex<s.length()){
            char c = s.charAt(curIndex);
            if (Character.isDigit(c)){
                int indexOfNoDigit = parseNum(s, curIndex);
                String curDigit = s.substring(curIndex, indexOfNoDigit);
                numStack.push(Integer.parseInt(curDigit));
                curIndex = indexOfNoDigit;
            }else if (c=='['){
                stringStack.push("[");
                curIndex++;
            }else if (Character.isLetter(c)){
                int indexOfNoChar = parseChar(s, curIndex);
                String curChar = s.substring(curIndex, indexOfNoChar);
                stringStack.push(curChar);
                curIndex = indexOfNoChar;
            }else {
                StringBuilder sb = new StringBuilder();
                while (!Objects.equals(stringStack.peek(), "[")){
                    String pop = stringStack.pop();
                    sb.insert(0,pop);
                }
                String curString = sb.toString();
                Integer curNum = numStack.pop();
                stringStack.pop();
                String genString = genString(curString, curNum);
                stringStack.push(genString);
                curIndex++;
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stringStack.isEmpty()){
            String pop = stringStack.pop();
            result.insert(0,pop);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]d";
        String s1 = decodeString(s);
        System.out.println(s1);
    }

    private static String genString(String s,int num){
        StringBuilder stringBuilder =  new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    private static int parseNum(String s,int index){
        while (index<s.length()){
            char c = s.charAt(index);
            if (Character.isDigit(c)){
                index++;
                continue;
            }
            return index;
        }
        return index;
    }

    private static int parseChar(String s,int index){
        while (index<s.length()){
            char c = s.charAt(index);
            if (Character.isLetter(c)){
                index++;
                continue;
            }
            return index;
        }
        return index;
    }

}

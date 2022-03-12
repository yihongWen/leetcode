package zyj.yihong.leetcode.mid.stack;

import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckValidString678 {
    public static boolean checkValidString(String s) {
        Stack<Integer> leftBracketsStack = new Stack<>();
        Stack<Integer> starBracketsStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='*'){
                starBracketsStack.push(i);
                continue;
            }else if (c=='('){
                leftBracketsStack.push(i);
                continue;
            }else {
                if (!leftBracketsStack.isEmpty()){
                    leftBracketsStack.pop();
                    continue;
                }else if (!starBracketsStack.isEmpty()){
                    starBracketsStack.pop();
                    continue;
                }
            }
            return false;
        }

        if (leftBracketsStack.size()!=0&&starBracketsStack.size()<leftBracketsStack.size()){
            return false;
        }
        while (!leftBracketsStack.isEmpty()){
            Integer leftIndex = leftBracketsStack.pop();
            Integer starIndex = starBracketsStack.pop();
            if (leftIndex>starIndex){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(*)";
        boolean b = checkValidString(s);
        System.out.println(b);
    }
}

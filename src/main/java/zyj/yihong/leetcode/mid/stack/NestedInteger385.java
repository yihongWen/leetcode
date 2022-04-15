package zyj.yihong.leetcode.mid.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 385. 迷你语法分析器
 * 给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/mini-parser
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NestedInteger385 {
    public NestedInteger deserialize(String s) {
        // 如果没有[直接返回数字
        if (s.charAt(0)!='['){
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        int curNum = 0;
        int negative = 1;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar=='-'){
                negative = -1;
            }else if (Character.isDigit(curChar)){
                curNum = curNum*10+curChar-'0';
            } else if (curChar=='['){
                NestedInteger nestedInteger = new NestedInteger();
                stack.push(nestedInteger);
            }else if (curChar==','||curChar==']'){
                // 考虑[111,[112],[113]]、[111,112]
                // 如果前一个是数字的话，放置在栈顶对象中
                if (Character.isDigit(s.charAt(i-1))){
                    stack.peek().add(new NestedInteger(curNum*negative));
                }

                // 重置当前的数字
                curNum = 0;
                negative = 1;

                // 如果是这种情况，[111,[112,113]]，最后一个],代表将【112，113】，放置在111同级(前一个级别)的对象当中
                if (curChar==']' && stack.size()>1){
                    NestedInteger pop = stack.pop();
                    stack.peek().add(pop);
                }
            }
        }
        return stack.pop();

    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class  NestedInteger {
        public NestedInteger(){

        }
        public NestedInteger(int value){

        }
        public boolean isInteger(){
            return true;
        }
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){
            return 0;
        }
        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){
        }
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){

        }
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return new ArrayList<>();
        }
    }

}





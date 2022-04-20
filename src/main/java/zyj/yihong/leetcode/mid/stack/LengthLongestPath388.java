package zyj.yihong.leetcode.mid.stack;

import java.util.Stack;

/**
 * 388. 文件的最长绝对路径
 */
public class LengthLongestPath388 {
    public static int lengthLongestPath(String input) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        // 使用栈的方式，如果判断当前节点是文件，那么计算当前文件名的长度，计算完成后，恢复到上一个节点到当前文件
        // 节点的栈状态
        int curIndex = 0;
        int end = input.length();
        while (curIndex<end){
            boolean isFile = false;

            // 当前行的深度、长度
            int curLineDepth = 1;
            int curLen = 0;

            // 遇到\t深度加1
            while (curIndex<end&&input.charAt(curIndex)=='\t'){
                curLineDepth++;
                curIndex++;
            }

            // 统计当前的文件或者目录名,如果遍历文件，则名称中会存在.
            // 如果是遇到\n则证明是下一行准备开始
            while (curIndex<end&&input.charAt(curIndex)!='\n'){
                if (input.charAt(curIndex)=='.'){
                    isFile = true;
                }
                curLen++;
                curIndex++;
            }

            curIndex++;

            // 判断当前的是从上一层的文件目录
            while (stack.size()>= curLineDepth){
                stack.pop();
            }

            // 如果当前不是根目录，则加上 "/"
            if (!stack.isEmpty()) {
                curLen += stack.peek() + 1;
            }
            // 计算如果是文件当前的长度
            if (isFile){
                ans = Math.max(curLen,ans);
            }else {
                // 不是文件压栈
                stack.push(curLen);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int i = lengthLongestPath(input);
        System.out.println(i);
        System.out.println("dir/subdir2/subsubdir2/file2.ext".length());

    }
}

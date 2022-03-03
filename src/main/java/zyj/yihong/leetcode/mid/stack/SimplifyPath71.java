package zyj.yihong.leetcode.mid.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 */
public class SimplifyPath71 {

    /**
     * 使用栈的方法(在执行完后需要逆序，使用双端队列会好)
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        // 切分字符串
        String[] splitPath = path.split("/");

        // 定义双端队列
        Deque<String> deque = new ArrayDeque<>();

        for (String s : splitPath) {
            if (s.equals(".")||s.isEmpty()){
                continue;
            }
            if (s.equals("..")){
                if (deque.size()>0) {
                    deque.pollLast();
                }
            }else {
                deque.offerLast(s);
            }
        }

        // 构造路径
        if (deque.size()==0){
            return "/";
        }

        StringBuilder simplePath = new StringBuilder();
        while (deque.size()>0){
            String s = deque.pollFirst();
            simplePath.append("/").append(s);
        }

        return simplePath.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        String simplifyPath = simplifyPath(path);
        System.out.println(simplifyPath);
    }

}

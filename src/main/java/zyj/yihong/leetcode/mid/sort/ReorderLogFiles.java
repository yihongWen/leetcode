package zyj.yihong.leetcode.mid.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 937. 重新排列日志文件
 * 有两种不同类型的日志：
 * <p>
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * <p>
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-data-in-log-files
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        // 构造待排序Node
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            nodes.add(new Node(logs[i], i));
        }

        // 排序
        //             * 所有 字母日志 都排在 数字日志 之前。
//                    * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
//                    * 数字日志 应该保留原来的相对顺序。

        nodes.sort((o1, o2) -> {
            // 拆分字符串，标识符+内容
            String[] s1 = o1.getInfo().split(" ", 2);
            String[] s2 = o2.getInfo().split(" ", 2);

            boolean d1 = Character.isDigit(s1[1].charAt(0));
            boolean d2 = Character.isDigit(s2[1].charAt(0));

            // 如果都是数字,保留index的相对顺序
            if (d1 && d2) {
                return o1.index - o2.index;
            }

            // 如果都是字母
            if ((!d1) && (!d2)) {
                // 先判断内容是否相等
                int compare = s1[1].compareTo(s2[1]);

                // 内容相等：
                if (compare == 0) {
                    return s1[0].compareTo(s2[0]);
                }

                // 内容不相等
                return compare;

            }

            // 一个是数字，一个是字母的情况
            return d1 ? 1 : -1;
        });

        // 返回结果
        for (int i = 0; i < logs.length; i++) {
            logs[i] = nodes.get(i).getInfo();
        }
        return logs;
    }

    public static void main(String[] args) {
//        String[] arr = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] arr = {"dig1 8 1 5 1", "dig2 3 6",  "let3 1 1"};

        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String[] strings = reorderLogFiles.reorderLogFiles(arr);
        System.out.println(Arrays.toString(strings));

    }

    static class Node {
        String info;
        int index;

        public Node(String info, int index) {
            this.info = info;
            this.index = index;
        }

        public String getInfo() {
            return info;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }
}

package zyj.yihong.leetcode.random_select.seg;

// 1598. 文件夹操作日志搜集器
public class MinOperations_S_1598 {
    public static int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if (log.startsWith("../")){
                if (ans>0) {
                    ans--;
                }
            }else if (log.startsWith("./")){
                continue;
            }else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] log  = {"./","../","./"};
        int i = minOperations(log);
        System.out.println(i);

    }
}

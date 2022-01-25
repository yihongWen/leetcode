package zyj.yihong.leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 *
 */
public class RestoreIpAddresses193 {

    /**
     * 当前结果集
     */
    static int[] curIpSegment = new int[4];

    /**
     * 全部结果
     */
    static List<String> retList = new ArrayList<>();

    /**
     * 使用回溯的方式解决：深度优先搜索+剪枝函数
     * @param s 给定字符串
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        if (s==null || s.length()<4){
            return null;
        }
        dfs(s,0,0);
        return retList;
    }

    public static void dfs(String s, int segId, int segStart) {
        // 1.结束条件 sigId满足4段，并且s已经是最后一位,此时是一种正确答案
        if (segId==4) {
            if (segStart == s.length()) {
                StringBuilder curIp = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    curIp.append(curIpSegment[i]);
                    if (i != 3) {
                        curIp.append(".");
                    }
                }
                retList.add(curIp.toString());
            }
            return;
        }

        // 到达长度，确不满足的情况
        if (segStart==s.length()){
            return;
        }

        // 如果当前的值为0，那么0不能作为前缀，直接下一层进行深度遍历
        if (s.charAt(segStart)=='0'){
            curIpSegment[segId] = 0;
            dfs(s,segId+1,segStart+1);
        }

        // 正常情况下，一次遍历枚举
        int address = 0;
        for (int i = segStart; i < s.length(); i++) {
            address = address*10+ s.charAt(i)-'0';
            // 不满足地址段大小条件
            if (address>255 || address<=0){
                break;
            }
            curIpSegment[segId] =address;
            dfs(s,segId+1,i+1);

        }

    }

    public static void main(String[] args) {
        String s = "0000";
        List<String> stringList = restoreIpAddresses(s);
        stringList.forEach(System.out::println);
    }

}

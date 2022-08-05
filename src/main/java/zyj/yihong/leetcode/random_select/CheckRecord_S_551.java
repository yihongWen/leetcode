package zyj.yihong.leetcode.random_select;

/**
 * 551. 学生出勤记录 I
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 *
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 */
public class CheckRecord_S_551 {
    public static boolean checkRecord(String s) {
        int aCount = 0;
        int lSeriesCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='A'){
                lSeriesCount = 0;
                aCount++;
            }else if (c=='L'){
                lSeriesCount++;
            }else {
                lSeriesCount = 0;
            }

            if (aCount==2||lSeriesCount==3){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean lall = checkRecord("LALL");
        System.out.println(lall);
    }
}

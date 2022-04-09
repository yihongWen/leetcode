package zyj.yihong.leetcode.simple;

/**
 * 2224. 转化时间需要的最少操作数
 */
public class ConvertTime2224 {
    public int convertTime(String current, String correct) {
        // 计算两者之间一共相差多少分钟
        int curHour = Integer.parseInt(current.substring(0, 2));
        int corHour = Integer.parseInt(correct.substring(0, 2));
        int curMin = Integer.parseInt(current.substring(3));
        int corMin = Integer.parseInt(correct.substring(3));

        int hour = corHour - curHour;
        hour = hour<0?hour+24:hour;
        int min = corMin - curMin;

        int totalMin = hour * 60 + min;

        int count = 0;
        count+=totalMin/60;
        totalMin = totalMin % 60;
        count+=totalMin/15;
        totalMin = totalMin % 15;
        count+=totalMin/5;
        totalMin= totalMin%5;
        count+=totalMin;
        return count;
    }
}

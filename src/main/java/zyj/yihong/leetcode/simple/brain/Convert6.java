package zyj.yihong.leetcode.simple.brain;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class Convert6 {
    /**
     * 模拟二维矩阵
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        // 特殊情况：row>s.length
        if (numRows > s.length() || numRows == 1) {
            return s;
        }

        // 计算周期、每个周期的列数、二维数组的列数
        int cycle = 2 * numRows - 2;
        int cycleCol = numRows - 1;
        int arrCol = (s.length() + cycle - 1) / cycle * cycleCol;
        char[][] convertArray = new char[numRows][arrCol];

        // 计算二维数组的数据
        int arrCurRow = 0;
        int arrCurCol = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            convertArray[arrCurRow][arrCurCol] = c;
            // 往下走
            if (i % cycle < (numRows - 1)) {
                arrCurRow++;
            } else {
                arrCurRow--;
                arrCurCol++;
            }
        }

        // 取出二维数组的数据，封装结果
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < convertArray.length; i++) {
            char[] rowArray = convertArray[i];
            for (int j = 0; j < rowArray.length; j++) {
                if (convertArray[i][j] != 0) {
                    stringBuilder.append(convertArray[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 直接构造结果
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        // 特殊情况：row>s.length
        if (numRows > s.length() || numRows == 1) {
            return s;
        }

        // 计算周期、每个周期的列数、二维数组的列数
        int cycle = 2 * numRows - 2;
        int cycleCol = numRows - 1;


        // 遍历每一行
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            // 遍历每一个周期
            for (int j = 0; j + i < s.length(); j = j + cycle) {
                // 当前周期的第一个值
                stringBuilder.append(s.charAt(i + j));
                // 判断当前周期是否存在第二个值
                if (i > 0 && i < (numRows - 1) && j + cycle - i < s.length()) {
                    stringBuilder.append(s.charAt(j + cycle - i));
                }

            }
        }

        return stringBuilder.toString();
    }

    public static String nearestPalindromic(String n) {
        // 构造候选边界值
        List<Long> selectList = new ArrayList<Long>(5);
        selectList.add((long) Math.pow(10, n.length() - 1) - 1);
        selectList.add((long) Math.pow(10, n.length()) + 1);

        int midIndex = (n.length() + 1) / 2;
        String prefix = n.substring(0, midIndex);
        long prefixLong = Long.parseLong(prefix);

        for (long i = prefixLong - 1; i <= prefixLong + 1; i++) {
            StringBuilder curResult = new StringBuilder();
            StringBuilder reverseSb = new StringBuilder();
            String curPrefix = String.valueOf(i);
            curResult.append(curPrefix);
            // 反转
            reverseSb.append(curPrefix).reverse();
            // 判断拼接的位数，如果是偶数，从头开始，如果是基数从第二位开始
            curResult.append(reverseSb.substring(n.length() & 1));
            selectList.add(Long.parseLong(curResult.toString()));
        }

        // 选择最佳的回文数
        long optValue = selectList.get(0);
        long longN = Long.parseLong(n);
        for (int i = 1; i < selectList.size(); i++) {
            if (selectList.get(i) == longN) {
                continue;
            }
            long compare = Math.abs(longN - optValue) - Math.abs(longN - selectList.get(i));
            if (compare > 0) {
                optValue = selectList.get(i);
            } else if (compare == 0) {
                optValue = optValue > selectList.get(i) ? selectList.get(i) : optValue;
            }
        }
        return String.valueOf(optValue);
    }


    public static void main(String[] args) {
//        String s = "PAYPALISHIRING";
//        String convert = convert1(s, 3);
//        System.out.println(convert);
//        String convert1 = convert(s, 3);
//        System.out.println(convert1);
        String s = nearestPalindromic("99321");
        System.out.println(s);
    }
}

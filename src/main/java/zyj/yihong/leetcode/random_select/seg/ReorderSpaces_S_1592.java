package zyj.yihong.leetcode.random_select.seg;

public class ReorderSpaces_S_1592 {
    public String reorderSpaces(String text) {
        // 去除两头两尾之后空格然后根据正则表达式对一个或者多个空格进行划分
        String[] split = text.trim().split("\\s+");

        // 统计出空白的个数
        int alphabetCount = 0;
        for (String s : split) {
            alphabetCount += s.length();
        }
        int whiteCount = text.length() - alphabetCount;

        // 如果是一个字符那么直接将空白拼接在最后
        StringBuilder stringBuilder = new StringBuilder();
        if (split.length == 1) {
            stringBuilder.append(split[0]);
            for (int i = 0; i < whiteCount; i++) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }

        // 不止一个字符，计算出间距空白的个数
        int gapCount = whiteCount / (split.length - 1);
        int tailCount = whiteCount % (split.length - 1);
        stringBuilder.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            for (int j = 0; j < gapCount; j++) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(split[i]);
        }

        for (int i = 0; i < tailCount; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "    abc  ggg uu";
        String[] s1 = s.split("\\s+");
        System.out.println(s1);
    }
}

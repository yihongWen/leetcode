package zyj.yihong.leetcode.random_select.seg;

// 537. 复数乘法
public class ComplexNumberMultiply_M_537 {
    public String complexNumberMultiply(String num1, String num2) {
        // 解析
        int[] num1Arr = parse(num1);
        int[] num2Arr = parse(num2);
        int r = num1Arr[0] * num2Arr[0] - num1Arr[1] * num2Arr[1];
        int p = num1Arr[0] * num2Arr[1] + num1Arr[1] * num2Arr[0];
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder ans = stringBuilder.append(r).append("+").append(p).append("i");
        return ans.toString();
    }


    private int[] parse(String complexNum) {
        int[] ans = new int[2];
        String[] num1Split = complexNum.split("\\+");

        String s = num1Split[0];
        boolean flag = false;
        int index = 0;
        if (s.charAt(0) == '-') {
            flag = true;
            index = 1;
        }

        int a1 = 0;
        int p = 10;
        for (int i = index; i < s.length(); i++) {
            int c = s.charAt(i)-'0';
            a1 = (a1) * p + c;
        }
        if (flag) {
            a1 = -a1;
        }
        ans[0] = a1;

        String complex = num1Split[1];
        flag = false;
        index = 0;
        int a2 = 0;
        if (complex.charAt(0) == '-') {
            flag = true;
            index = 1;
        }
        for (int i = index; i < complex.length() - 1; i++) {
            int c = complex.charAt(i)-'0';
            a2 = (a2) * p + c;
        }

        if (flag) {
            a2 = -a2;
        }
        ans[1] = a2;
        return ans;
    }

    public static void main(String[] args) {
        String num1 = "1+-1i", num2 = "1+-1i";
        ComplexNumberMultiply_M_537 complexNumberMultiply_m_537 = new ComplexNumberMultiply_M_537();
        String s = complexNumberMultiply_m_537.complexNumberMultiply(num1, num2);
        System.out.println(s);
    }
}

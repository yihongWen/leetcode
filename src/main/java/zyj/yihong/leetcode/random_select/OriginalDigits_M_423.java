package zyj.yihong.leetcode.random_select;

// 423. 从英文中重建数字
public class OriginalDigits_M_423 {
    public static String originalDigits(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        // 确定0-9的个数
        int[] count = new int[10];
        count[0] = arr['z' - 'a'];
        count[2] = arr['w' - 'a'];
        count[4] = arr['u' - 'a'];
        count[6] = arr['x' - 'a'];
        count[8] = arr['g' - 'a'];

        count[3] = arr['r' - 'a'] - count[0] - count[4];
        count[5] = arr['f' - 'a'] - count[4];
        count[7] = arr['s' - 'a'] - count[6];

        count[1] = arr['o' - 'a'] - count[0] - count[2] - count[4];
        count[9] = arr['i' - 'a'] - count[6] - count[8] - count[5];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    stringBuilder.append(i);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        "owoztneoer"
        String owoztneoer = originalDigits("fviefuro");
        System.out.println(owoztneoer);

    }
}

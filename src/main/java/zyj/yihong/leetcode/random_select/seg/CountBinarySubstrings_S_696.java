package zyj.yihong.leetcode.random_select.seg;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 696. 计数二进制子串
public class CountBinarySubstrings_S_696 {
    public static int countBinarySubstrings(String s) {
        char temp = s.charAt(0);
        int curCount = 1;
        int preCount = 0;
        int ans = 0;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == temp) {
                curCount++;
                if (i==s.length()-1){
                    ans+=Math.min(preCount,curCount);
                }
                continue;
            }
            temp = c;
            preCount = curCount;
            curCount = 1;

            if (i==s.length()-1){
                ans+= Math.min(curCount,preCount);
                return ans;
            }

            i++;
            while (i<s.length()){
                char c1 = s.charAt(i);
                if (c1==temp){
                    curCount++;
                    if (i==s.length()-1){
                        ans+= Math.min(curCount,preCount);
                        return ans;
                    }
                    i++;
                }else {
                    ans += Math.min(preCount, curCount);
                    i--;
                    break;
                }
            }
        }
        return ans;
    }


    public static int countBinarySubstrings1(String s) {
        char temp = s.charAt(0);
        int curCount = 1;
        List<Integer> countList = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == temp) {
                curCount++;
                continue;
            }
            countList.add(curCount);
            temp = c;
            curCount = 1;
        }

        countList.add(curCount);

        int ans = 0;
        for (int i = 1; i < countList.size(); i++) {
            ans += Math.min(countList.get(i - 1), countList.get(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        int i = countBinarySubstrings("0111110000");
        System.out.println(i);
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int j = 0; j < 10; j++) {
//                int num = (random.nextInt() & 1) == 0 ? 1 : 0;
//                stringBuilder.append(num);
//            }
//            int i1 = countBinarySubstrings(stringBuilder.toString());
//            int i2 = countBinarySubstrings1(stringBuilder.toString());
//            if (i2!=i1){
//                System.out.println(stringBuilder.toString());
//            }
//        }
    }
}

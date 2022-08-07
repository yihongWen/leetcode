package zyj.yihong.leetcode.random_select;

public class CountSegments_S_434 {
    public int countSegments(String s) {
        if (s.length()==0){
            return 0;
        }
        int ans = 0;
        boolean handle = false;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i)==' '){
                if (handle) {
                    ans++;
                }
                while (i<s.length()&&s.charAt(i)==' '){
                    i++;
                }
                continue;
            }
            handle = true;
            i++;
        }
        return ((ans==0&&handle)||s.charAt(s.length()-1)!=' ')?ans+1:ans;
    }


    public int countSegments2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i==0||s.charAt(i-1)==' ') && s.charAt(i)!=' '){
                ans++;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        CountSegments_S_434 countSegments_s_434 = new CountSegments_S_434();
        String s = "Of all the gin joints in all the towns in all the world";
        int i = countSegments_s_434.countSegments(s);
        System.out.println(i);
    }
}

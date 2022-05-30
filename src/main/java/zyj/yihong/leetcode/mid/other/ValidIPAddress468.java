package zyj.yihong.leetcode.mid.other;

/**
 * 468. 验证IP地址
 */
public class ValidIPAddress468 {
    public static String validIPAddress(String queryIP) {
        boolean v4 = checkV4(queryIP);
        if (v4){
            return "IPv4";
        }

        boolean v6 = checkV6(queryIP);
        if (v6){
            return "IPv6";
        }

        return "Neither";
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress(""));
    }

    private static boolean checkV6(String ip){

        String[] split = ip.split(":");
        if (split.length!=8){
            return false;
        }

        if (ip.charAt(0)==':'||ip.charAt(ip.length()-1)==':'){
            return false;
        }

        for (String s : split) {
            if (!(s.length()>=1&&s.length()<=4)){
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                boolean digit = Character.isDigit(c);
                char c1 = Character.toLowerCase(c);
                if (!(digit||(c1>='a'&&c1<='f'))){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkV4(String ip){

        String[] split = ip.split("\\.");
        if (split.length!=4){
            return false;
        }

        if (ip.charAt(0)=='.'||ip.charAt(ip.length()-1)=='.'){
            return false;
        }

        for (String s : split) {
            if (s.length()>3||s.length()==0){
                return false;
            }

            if (s.charAt(0)=='0'&&s.length()!=1){
                return false;
            }

            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))){
                    return false;
                }
            }

            if (Integer.parseInt(s)>255){
                return false;
            }
        }

        return true;
    }
}

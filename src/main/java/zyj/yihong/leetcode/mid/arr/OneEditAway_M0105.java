package zyj.yihong.leetcode.mid.arr;

/**
 * 一次编辑
 *
 */
public class OneEditAway_M0105 {
    public static boolean oneEditAway(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        if (Math.abs(l1-l2)>1){
            return false;
        }
        if (l1>l2){
            return handle(first,second);
        }
        return handle(second,first);
    }

    private static boolean handle(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        boolean flag =  l1==l2;
        int count = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1<l1&&index2<l2){
            char c1 = s1.charAt(index1);
            char c2 = s2.charAt(index2);
            if (c1==c2){
                index1++;
                index2++;
            }else if (count<1){
                if (flag){
                    index1++;
                    index2++;
                    count++;
                }else {
                    index1++;
                    count++;
                }
            }else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String first = "spartan";
        String second = "part";
        boolean b = oneEditAway(first, second);
        System.out.println(b);

    }
}

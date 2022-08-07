package zyj.yihong.leetcode.random_select;

import java.util.Arrays;

public class ValidSquare_593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1,p2)||Arrays.equals(p1,p3)||Arrays.equals(p1,p4)||Arrays.equals(p2,p3)||Arrays.equals(p2,p4)||Arrays.equals(p3,p4)){
            return false;
        }
        
        int a1 = p1[0];
        int a2 = p1[1];
        int b1 = p2[0];
        int b2 = p2[1];
        int c1 = p3[0];
        int c2 = p3[1];
        int d1 = p4[0];
        int d2 = p4[1];
        
        if ((a1==b1&&a1==c1)||(a1==b1&&a1==d1)||(a1==c1&&a1==d1)||(b1==c1&&b1==d1)){
            return false;
        }

        if ((a2==b2&&a2==c2)||(a2==b2&&a2==d2)||(a2==c2&&a2==d2)||(b2==c2&&b2==d2)){
            return false;
        }

        double len1 = Math.pow(Math.pow(Math.abs(b1 - a1), 2) + Math.pow(Math.abs(b2 - a2), 2), 0.5);
        double len2 = Math.pow(Math.pow(Math.abs(c1 - a1), 2) + Math.pow(Math.abs(c2 - a2), 2), 0.5);
        double len3 = Math.pow(Math.pow(Math.abs(d1 - a1), 2) + Math.pow(Math.abs(d2 - a2), 2), 0.5);
        double len4 = Math.pow(Math.pow(Math.abs(d1 - b1), 2) + Math.pow(Math.abs(d2 - b2), 2), 0.5);
        double len5 = Math.pow(Math.pow(Math.abs(d1 - c1), 2) + Math.pow(Math.abs(d2 - c2), 2), 0.5);
        double len6 = Math.pow(Math.pow(Math.abs(c1 - b1), 2) + Math.pow(Math.abs(c2 - b2), 2), 0.5);
        double max = Math.max(Math.max(Math.max(Math.max(Math.max(len1, len2), len3), len4), len5), len6);
        if (max==len1){
//            ab  ca\cb  da\db
            return len2==len6&&len3==len4&&len2==len3&&Math.abs(2*Math.pow(len2,2)-Math.pow(max,2))<0.0000001;
        }else if (max == len2){
//            ca  da\dc  bc\ba
            return len3==len5&&len6==len1&&len1==len3&&Math.abs(2*Math.pow(len3,2)-Math.pow(max,2))<0.0000001;
        }else if (max==len3){
//          da   ba\bd  ca\cd
            return len1==len4&&len2==len5&&len2==len1&&Math.abs(2*Math.pow(len2,2)-Math.pow(max,2))<0.0000001;
        }else if (max==len4){
//            db ad\ab cd\cb
            return len3==len1&&len5==len6&&len5==len3&&Math.abs(2*Math.pow(len3,2)-Math.pow(max,2))<0.0000001;
        }else if (max==len5){
//            cd ac\ad bc\bd
            return len2==len3&&len6==len4&&len2==len4&&Math.abs(2*Math.pow(len2,2)-Math.pow(max,2))<0.0000001;
        }else {
//            cb ac\ab dc\db
            return len2==len1&&len5==len4&&len2==len5&&Math.abs(2*Math.pow(len2,2)-Math.pow(max,2))<0.0000001;
        }


    }

    public static void main(String[] args) {
        ValidSquare_593 validSquare_593 = new ValidSquare_593();
//输入：
        int[] p1 = {0, 5};
        int[] p2 = {3, 1};
        int[] p3 = {5, 5};
        int[] p4 = {5, 0};
        boolean b = validSquare_593.validSquare(p1, p2, p3, p4);
        System.out.println(b);
        System.out.println(Arrays.equals(p1,p2));
        System.out.println(Math.pow(4,0.5));
    }
}

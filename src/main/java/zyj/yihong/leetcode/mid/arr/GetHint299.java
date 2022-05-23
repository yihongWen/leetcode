package zyj.yihong.leetcode.mid.arr;

/**
 * 299. 猜数字游戏
 *
 */
public class GetHint299 {

    public String getHint(String secret, String guess) {
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];
        int countBull = 0;
        int countCow = 0;

        for (int i = 0; i < secret.length(); i++) {
            int si = secret.charAt(i)-'0';
            int gi = guess.charAt(i)-'0';
            if (gi==si){
                countBull++;
            }else {
                secretArr[si]++;
                guessArr[gi]++;
            }
        }

        for (int i = 0; i <= 10 ; i++) {
            countCow+= Math.min(secretArr[i], guessArr[i]);
        }

        return countBull+"A"+countCow+"B";
    }



}

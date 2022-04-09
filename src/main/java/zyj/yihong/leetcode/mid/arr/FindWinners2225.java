package zyj.yihong.leetcode.mid.arr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 */
public class FindWinners2225 {
    public static List<List<Integer>> findWinners(int[][] matches) {
        TreeSet<Integer> allWin = new TreeSet<>();
        TreeSet<Integer> loseOne = new TreeSet<>();
        HashSet<Integer> loseMore = new HashSet<>();

        for (int[] match : matches) {
            int win = match[0];
            int lose = match[1];
            boolean loseOneContain = loseOne.contains(win);
            boolean allWinContain = allWin.contains(win);
            if (!loseOneContain && !allWinContain) {
                allWin.add(win);
            }

            loseOneContain = loseOne.contains(lose);
            allWinContain = allWin.contains(lose);
            if (loseOneContain){
                loseOne.remove(lose);
                loseMore.add(lose);
            }else if (allWinContain){
                allWin.remove(lose);
                loseOne.add(lose);
            }else {
                loseOne.add(lose);
            }
        }
        loseOne.removeAll(loseMore);
        allWin.removeAll(loseMore);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> win = new ArrayList<>(allWin);
        List<Integer> lose = new ArrayList<>(loseOne);
        ans.add(win);
        ans.add(lose);
        return ans;
    }

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> winners = findWinners(matches);
        System.out.println(winners.get(0).toString());
        System.out.println(winners.get(1).toString());

    }
}

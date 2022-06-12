package zyj.yihong.leetcode.simple.arr;

public class IsBoomerang1037 {
    public static boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;


    }

    public static void main(String[] args) {
//[[1,0],[1,1],[1,0]],
//        [[22,33],[37,27],[67,15]]

        int[][] arr = {{22,33},{37,27},{67,15}};
        boolean boomerang = isBoomerang(arr);
        System.out.println(boomerang);
    }
}

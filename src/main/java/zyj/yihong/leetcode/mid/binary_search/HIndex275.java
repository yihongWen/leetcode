package zyj.yihong.leetcode.mid.binary_search;

public class HIndex275 {
    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length-1;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if (citations[mid]<citations.length-mid){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return citations.length-left;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left<=right){
            int mid = (right - left) / 2 + left;
            int guess = guess(mid);
            if (guess==0){
                return mid;
            }else if (guess==1){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return -1;

    }

     private int guess(int num){
        return 1;
     }


    public static void main(String[] args) {
        int[] arr = {0,1,3,5,6};
        int hIndex = hIndex(arr);
        System.out.println(hIndex);
    }
}

package zyj.yihong.leetcode.random_select.seg;

// 832. 翻转图像
public class FlipAndInvertImage_S_832 {
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int left = 0;
            int right = image[i].length-1;
            while (left<=right){
                if (image[i][left]==image[i][right]){
                    // 异或取反
                    image[i][left] ^= 1;
                    image[i][right] = image[i][left];
                }
                left++;
                right--;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] ints = flipAndInvertImage(image);
        System.out.println(ints);

    }
}

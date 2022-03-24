package zyj.yihong.leetcode.simple.other;

/**
 * 661. 图片平滑器
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 *
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 *
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/image-smoother
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImageSmoother661 {
    /**
     * 模拟
     * @param img
     * @return
     */
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        // 一次计算每个值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算该单元格的周围
                int sum = 0;
                int count = 0;
                for (int k = i-1; k <= i+1 ; k++) {
                    for (int l = j-1; l <= j+1 ; l++) {
                        if (k>=0&&k<m && l>=0&&l<n){
                            sum = sum+img[k][l];
                            count++;
                        }
                    }
                }

                result[i][j] = sum/count;
            }
        }
        return result;
    }
}

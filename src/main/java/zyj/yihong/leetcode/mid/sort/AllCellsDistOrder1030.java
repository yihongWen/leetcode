package zyj.yihong.leetcode.mid.sort;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCellsDistOrder1030 {


    /**
     * 直接枚举出所有的点，然后根据曼哈顿距离进行排序
     * @param rows
     * @param cols
     * @param rCenter
     * @param cCenter
     * @return
     */
    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] retArr = new int[rows*cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                retArr[i*cols+j][0] = i;
                retArr[i*cols+j][1] = j;
            }
        }
        // 根据曼哈顿距离排序
        Arrays.sort(retArr,(o1,o2)-> Math.abs(o1[0]-rCenter)+Math.abs(o1[1]-cCenter)-Math.abs(o2[0]-rCenter)-Math.abs(o2[1]-cCenter));

        return retArr;
    }


    /**
     * 根据距离进行分桶
     * @param rows
     * @param cols
     * @param rCenter
     * @param cCenter
     * @return
     */
    public static int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {
        // 计算出最大的曼哈顿距离：
        int maxRow = Math.max(rCenter,rows-1-rCenter);
        int maxCol = Math.max(cCenter,cols-1-cCenter);
        int maxDis = maxCol+maxRow;

        // 建桶
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDis; i++) {
            bucket.add(new ArrayList<>());
        }

        // 遍历所有的点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 计算的当前点到目标点的距离
                int curDis = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                bucket.get(curDis).add(new int[]{i, j});
            }
        }

        int[][] ret = new int[rows * cols][];
        int index = 0;
        for (int i = 0; i <= maxDis; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }


    public static int[][] allCellsDistOrder3(int rows, int cols, int rCenter, int cCenter) {
        int[][] retArr = new int[rows*cols][2];
        // 计算出最大的曼哈顿距离：
        int maxRow = Math.max(rCenter,rows-1-rCenter);
        int maxCol = Math.max(cCenter,cols-1-cCenter);
        int maxDis = maxCol+maxRow;

        // 定义四个方向：右下、左下、左上、右上
        int[] dr = {1,1,-1,-1};
        int[] dc = {1,-1,-1,1};

        // 将原点加入
        int index = 0;
        retArr[index++] = new int[]{rCenter,cCenter};

        int curRow = rCenter;
        int curCol = cCenter;
        // 遍历距离从1到maxDis
        for (int i = 1; i <= maxDis ; i++) {
            curRow--;
            // 遍历四个方向上的点
            for (int j = 0; j < 4; j++) {
                // 如果是右下跟左上的方向，那么curRow!=rCenter
                while ((j%2==0&&curRow!=rCenter) ||(j%2!=0&&curCol!=cCenter)){
                    // 判断位置是否越界
                    if (curRow>=0&&curRow<rows&&curCol>=0&&curCol<cols){
                        retArr[index++] = new int[]{curRow,curCol};
                    }

                    // 沿着当前方向走
                    curRow = curRow+dr[j];
                    curCol = curCol+dc[j];
                }
                // 判断该方向上的点是否已经遍历完
            }
        }

        return retArr;
    }
    public static void main(String[] args) {
//        rows = 2, cols = 3, rCenter = 1, cCenter = 2
        int[][] ints = allCellsDistOrder3(2, 3, 1, 2);
        String s = new Gson().toJson(ints);
        System.out.println(s);
    }
}

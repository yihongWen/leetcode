package zyj.yihong.leetcode.mid.arr;

/**
 * 165. 比较版本号
 */
public class CompareVersion165 {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        int i = 0;
        int j = 0;

        // 双指针
        while (i<m||j<n){
            // 分别找出两个version的当前版本号
            int curV1 = 0;
            int curV2 = 0;

            for (; i <m ; i++) {
                if (version1.charAt(i)=='.'){
                    i++;
                    break;
                }
                curV1 = curV1*10+version1.charAt(i)-'0';
            }

            for (; j <n ; j++) {
                if (version2.charAt(j)=='.'){
                    j++;
                    break;
                }
                curV2 = curV2*10+version2.charAt(j)-'0';
            }
            if (curV1!=curV2){
                return curV1-curV2>0?1:-1;
            }
        }

        return 0;
    }
}

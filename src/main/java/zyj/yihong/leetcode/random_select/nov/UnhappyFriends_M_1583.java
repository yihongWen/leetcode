package zyj.yihong.leetcode.random_select.nov;

// 1583. 统计不开心的朋友
public class UnhappyFriends_M_1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // 输入n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
        int[][] friendIndex = new int[n][n];
        int[] friendParis = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                friendIndex[i][preferences[i][j]] = j;
            }
        }

        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            int x = pair[0];
            int y = pair[1];
            friendParis[x] = y;
            friendParis[y] = x;
        }

        for (int x = 0; x < n; x++) {
            int y = friendParis[x];
            int yInXIndex = friendIndex[x][y];
            for (int i = 0; i < yInXIndex; i++) {
                int u = preferences[x][i];
                int v = friendParis[u];
                int xInUIndex = friendIndex[u][x];
                int vInUIndex = friendIndex[u][v];
                if (xInUIndex < vInUIndex) {
                    ++ans;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] preferences = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
        int[][] pairs = {{0, 1}, {2, 3}};
        UnhappyFriends_M_1583 unhappyFriends_m_1583 = new UnhappyFriends_M_1583();
        int i = unhappyFriends_m_1583.unhappyFriends(4, preferences, pairs);
        System.out.println(i);
    }
}
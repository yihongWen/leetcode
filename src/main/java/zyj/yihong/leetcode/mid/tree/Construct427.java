package zyj.yihong.leetcode.mid.tree;

public class Construct427 {
    public Node construct(int[][] grid) {
        return dfs(grid,0,0, grid.length,grid[0].length);
    }

    // 深度搜索
    private Node dfs(int[][] grid, int x1, int y1, int x2, int y2) {
        // 判断当前的x1、y1 x2 y2围城的区域是一个什么样的Node
        boolean same = true;
        for (int i = x1; i <x2 ; i++) {
            for (int j = y1; j <y2 ; j++) {
                if (grid[i][j]!=grid[x1][y1]){
                    same = false;
                    break;
                }

                // 判断是否需要打断上层for
                if (!same){
                    break;
                }
            }
        }

        // 如果每个值都是一样，那么当前就是一个叶子节点
        if (same) {
            return new Node(grid[x1][y1] == 1, true);
        }

        // 否则该节点不是叶子节点，继续处理其子节点
        Node node1 = dfs(grid, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
        Node node3 = dfs(grid, (x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
        Node node4 = dfs(grid, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
        Node node2 = dfs(grid, x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
        return new Node(false,false,node1,node2,node3,node4);
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        Construct427 construct427 = new Construct427();
        Node construct = construct427.construct(grid);
        System.out.println(construct);
    }


    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;
}

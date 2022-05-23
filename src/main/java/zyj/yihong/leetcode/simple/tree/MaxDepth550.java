package zyj.yihong.leetcode.simple.tree;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MaxDepth550 {
    private int maxDepth = 0;
    private int curDepth = 0;
    public int maxDepth(Node root) {
        if (root==null){
            return maxDepth;
        }

        curDepth++;
        maxDepth = Math.max(curDepth, maxDepth);
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            maxDepth(children.get(i));
            curDepth--;
        }
        return maxDepth;
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str3 = "1927-12-31 23:54:07";
        String str4 = "1927-12-31 23:54:08";
        Date sDt3 = sf.parse(str3);
        Date sDt4 = sf.parse(str4);
        long ld3 = sDt3.getTime() /1000;
        long ld4 = sDt4.getTime() /1000;
        System.out.println(ld4-ld3);
    }
}

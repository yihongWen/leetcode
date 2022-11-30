package zyj.yihong.leetcode.random_select.nov;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 1656. 设计有序流
public class OrderedStream_S_1656 {

    private String[] arr;
    int ptr = 1;
    public OrderedStream_S_1656(int n) {
        arr = new String[n+1];

    }

    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        if (idKey!=ptr){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        do {
            ans.add(arr[ptr]);
            ptr++;
        } while (ptr< arr.length && arr[ptr] != null && !Objects.equals(arr[ptr], ""));
        return ans;
    }
}

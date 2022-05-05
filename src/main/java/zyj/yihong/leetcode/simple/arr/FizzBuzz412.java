package zyj.yihong.leetcode.simple.arr;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        String f = "Fizz";
        String z = "Buzz";
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String cur = "";
            if (i%3==0){
                cur+=f;
            }
            if (i%5==0){
                cur+=z;
            }
            if (cur.length()==0){
                cur+=i;
            }
            ans.add(cur);
        }
        return ans;
    }
}

package zyj.yihong.leetcode.random_select.seg;

import java.util.*;

// 811. 子域名访问计数
public class SubdomainVisits_M_811 {
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            StringBuilder stringBuilder = new StringBuilder();

            // 分割次数
            String[] s = cpdomain.split(" ");
            int count = Integer.parseInt(s[0]);

            // 分割域名
            String[] domain = s[1].split("\\.");
            for (int i = domain.length - 1; i >= 0; i--) {
                stringBuilder.insert(0,domain[i]);
                map.put(stringBuilder.toString(),map.getOrDefault(stringBuilder.toString(),0)+count);
                stringBuilder.insert(0,".");
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            String s = v+" "+k;
            ans.add(s);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] arr =  {"9001 discuss.leetcode.com"};
        List<String> ans = subdomainVisits(arr);
        System.out.println(ans);

    }
}

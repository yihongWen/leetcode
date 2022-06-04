package zyj.yihong.leetcode.simple.simulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 */
public class NumUniqueEmails929 {
    public static int numUniqueEmails(String[] emails) {
//        输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String name = split[0];
            int index = name.indexOf("+");
            if (index!=-1) {
                name = name.substring(0, index);
            }
            name = name.replace(".", "");
            String domain = split[1];
            set.add(name+"_"+domain);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};

    }
}

package zyj.yihong.leetcode.hard.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 420. 强密码检验器
 * 如果一个密码满足下述所有条件，则认为这个密码是强密码：
 * 由至少 6 个，至多 20 个字符组成。
 * 至少包含 一个小写 字母，一个大写 字母，和 一个数字 。
 * 同一字符 不能 连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 如果满足其他条件也可以算是强密码)。
 * 给你一个字符串 password ，返回 将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 。
 * <p>
 * 在一步修改操作中，你可以：
 * <p>
 * 插入一个字符到 password ，
 * 从 password 中删除一个字符，或
 * 用另一个字符来替换 password 中的某个字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strong-password-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrongPasswordChecker420 {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (int i = 0; i < n; ++i) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = 1;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = 1;
            } else if (Character.isDigit(ch)) {
                hasDigit = 1;
            }
        }
        // 计算当前字符种类的个数
        int categories = hasLower + hasUpper + hasDigit;

        // 情况1：只需要执行添加操作、如果出现连续3、4、5的情况
        if (n < 6) return case1(password, categories);
        if (n <= 20) return case2(password, categories);
        return case3(password, categories);
    }

    private int case1(String password, int categories) {
        // a  aa  aaa aaaa aaaaa(最极端的情况)
        return Math.max(6 - password.length(), 3 - categories);
    }

    private int case2(String password, int categories) {
        // 处于6-20之间：只需要执行替换操作
        // 相当于没遇到连续3个 替换一次即可
        // aaa  aaaa   aaaaa 替换一次  aaaaaa:需要两次
        int replace = 0;
        int cnt = 0;
        char cur = '#';

        for (int i = 0; i < password.length(); ++i) {
            char ch = password.charAt(i);
            if (ch == cur) {
                ++cnt;
            } else {
                replace += cnt / 3;
                cnt = 1;
                cur = ch;
            }
        }
        replace += cnt / 3;
        return Math.max(replace, 3 - categories);
    }

    private int case3(String password, int categories) {
        // 在不考虑删除操作影响替换操作的情况下，分别计算删除次数、以及替换次数
        int replace = 0, remove = password.length() - 20;
        // k mod 3 = 1 的组数，即删除 2 个字符可以减少 1 次替换操作
        int cnt = 0;
        char cur = '#';
        List<Integer>[] groupList = new List[3];
        for (int i = 0; i < 3; i++) {
            groupList[i] = new ArrayList<>();
        }

        for (int i = 0; i < password.length(); ++i) {
            char ch = password.charAt(i);
            if (ch == cur) {
                ++cnt;
            } else {
                if (cnt >= 3) {
                    groupList[cnt % 3].add(cnt);
                }
                cnt = 1;
                cur = ch;
            }
        }
        if (cnt >= 3) {
            groupList[cnt % 3].add(cnt);
        }


        for (int i = 0; i < groupList[0].size(); i++) {
            Integer curCount = groupList[0].get(i);
            int num = curCount / 3;
            if (remove == 0) {
                replace = replace + num;
                continue;
            }
            // 计算当前可以删除的个数
            int x = 0;
            while (remove >= 3 * x + 1 && 3 * x + 1 <= curCount) {
                x++;
            }
            int removeCount = 3 * (x-1) + 1;

            int remind = curCount - removeCount;
            replace += remind / 3;
            groupList[0].set(i, remind);
            remove -= removeCount;

        }

        for (int i = 0; i < groupList[1].size(); i++) {
            Integer curCount = groupList[1].get(i);
            int num = curCount / 3;
            if (remove == 0) {
                replace = replace + num;
                continue;
            }
            // 计算当前可以删除的个数
            int x = 0;
            while (remove >= 3 * x + 2 && 3 * x + 2 <= curCount) {
                x++;
            }
            int removeCount = 3 * x + 2;

            if (remove>=2) {
                if (remove<removeCount) {
                    removeCount-=3;
                }
                int remind = curCount - removeCount;
                replace += remind / 3;
                groupList[1].set(i, remind);
                remove -= removeCount;
            }else {
                replace+=curCount/3;
            }
        }


        for (int i = 0; i < groupList[2].size(); i++) {
            Integer curCount = groupList[2].get(i);
            int num = curCount / 3;
            if (remove == 0) {
                replace = replace + num;
                continue;
            }
            // 计算当前可以删除的个数
            int x = 0;
            while (remove >= 3 * (x + 1) && 3 * (x + 1) <= curCount) {
                x++;
            }
            int removeCount = 3 * x;

            int remind = curCount - removeCount;
            replace += remind / 3;
            groupList[2].set(i, remind);
            remove -= removeCount;
        }

        return (password.length() - 20) + Math.max(replace, 3 - categories);
    }


    public static void main(String[] args) {
//        "aaaaaaaAAAAAA6666bbbbaaaaaaABBC"
//        String s = "A1234567890aaabbbbccccc";
        String s = "aaaaaaaAAAAAA6666bbbbaaaaaaABBC";
        StrongPasswordChecker420 strongPasswordChecker420 = new StrongPasswordChecker420();
        int count = strongPasswordChecker420.strongPasswordChecker(s);
        System.out.println(count);
//      bb aa*aa*aa*aa*aacc*c

//        "aaaaaAA66bbbbaABBC"
//        "aaaaaaAA66bbbbaaABBC"
    }

}

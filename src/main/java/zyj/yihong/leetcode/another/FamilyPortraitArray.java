package zyj.yihong.leetcode.another;

import java.util.*;

public class FamilyPortraitArray {

    public static List<List<String>> familyPortraitArray(String[] member) {
        List<String> memberList = new ArrayList<>();
        Collections.addAll(memberList, member);
        List<List<String>> output = new ArrayList<>();
        backtrack(0, member.length, memberList, output);
        return output;
    }

    public static void backtrack(int start, int length, List<String> member, List<List<String>> output) {
        if (start == length && constraint(member)) {
            output.add(new ArrayList<>(member));
        }

        for (int i = start; i < length; i++) {
            Collections.swap(member, i, start);
            backtrack(start + 1, length, member, output);
            Collections.swap(member, i, start);
        }
    }

    private static boolean constraint(List<String> member) {
        Map<String, Integer> memberIndexMap = new HashMap<>();
        for (int i = 0; i < member.size(); i++) {
            memberIndexMap.put(member.get(i), i);
        }
        int condition1 = Math.abs(memberIndexMap.get("father") - memberIndexMap.get("grandmother"));
        if (condition1 != 2) {
            return false;
        }
        int condition2 = memberIndexMap.get("grandfather") - memberIndexMap.get("grandmother");
        if (condition2 != 1) {
            return false;
        }
        int condition3 = memberIndexMap.get("liang") - memberIndexMap.get("father");
        if (condition3 <= 0) {
            return false;
        }
        int condition4 = Math.abs(memberIndexMap.get("father") - memberIndexMap.get("mother"));
        if (condition4 != 3) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] member = {"father", "liang", "mother", "grandmother", "grandfather"};
        List<List<String>> familyPortraitArray = familyPortraitArray(member);
        System.out.println(familyPortraitArray);
    }

}

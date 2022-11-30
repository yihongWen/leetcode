package zyj.yihong.leetcode.random_select.nov;

public class ExpressiveWords_M_809 {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (checkExpressive(word,s)){
                ans++;
            }
        }
        return ans;
    }


    private boolean checkExpressive(String originString,String expressiveString){
        int originIndex = 0;
        int expressiveIndex = 0;

        while (originIndex<originString.length()&&expressiveIndex<expressiveString.length()){
            // 如果当前第一个词不一致
            if (originString.charAt(originIndex)!=expressiveString.charAt(expressiveIndex)){
                return false;
            }
            int oriCount = 0;
            int expCount = 0;
            char c = expressiveString.charAt(expressiveIndex);

            while (originIndex<originString.length()&&c==originString.charAt(originIndex)){
                oriCount++;
                originIndex++;
            }

            while (expressiveIndex<expressiveString.length()&&c==expressiveString.charAt(expressiveIndex)){
                expCount++;
                expressiveIndex++;
            }

            if (oriCount>expCount){
                return false;
            }

            if (oriCount!=expCount && expCount<3){
                return false;
            }

        }


        return originIndex==originString.length()&&expressiveIndex==expressiveString.length();
    }
}

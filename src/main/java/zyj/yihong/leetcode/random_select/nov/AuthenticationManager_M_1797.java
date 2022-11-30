package zyj.yihong.leetcode.random_select.nov;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 1797. 设计一个验证系统
public class AuthenticationManager_M_1797 {

    Map<String,Integer> map = new HashMap<>();
    int timeToLive;
    public AuthenticationManager_M_1797(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)){
            return;
        }

        Integer time = map.get(tokenId);
        if (time+timeToLive<=currentTime){
            return;
        }
        map.put(tokenId,currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue()+timeToLive>currentTime){
                ans++;
                continue;
            }
            iterator.remove();
        }
        return ans;
    }

    public static void main(String[] args) {
//        ["AuthenticationManager","renew","generate","countUnexpiredTokens","generate","renew","renew","countUnexpiredTokens"]
//[[5],["aaa",1],["aaa",2],[6],["bbb",7],["aaa",8],["bbb",10],[15]]
        AuthenticationManager_M_1797 authenticationManager_m_1797 = new AuthenticationManager_M_1797(5);
        authenticationManager_m_1797.renew("aaa",1);
        authenticationManager_m_1797.generate("aaa",2);
        int i1 = authenticationManager_m_1797.countUnexpiredTokens(6);
        authenticationManager_m_1797.generate("bbb",7);
        authenticationManager_m_1797.renew("aaa",8);
        authenticationManager_m_1797.renew("bbb",10);
        int i = authenticationManager_m_1797.countUnexpiredTokens(15);
        System.out.println(i1);
        System.out.println(i);


    }
}

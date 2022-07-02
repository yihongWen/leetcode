package zyj.yihong.leetcode.mid;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 535. TinyURL 的加密与解密
 */
public class Codec_535 {
    private Map<Integer,String> map = new HashMap<>();
    private AtomicInteger incId = new AtomicInteger(0);

    public String encode(String longUrl) {
        int id = incId.addAndGet(1);
        map.put(id,longUrl);
        return "http://zhiyujiang/"+id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.lastIndexOf("/");
        int id = Integer.parseInt(shortUrl.substring(index + 1));
        return map.get(id);
    }


}

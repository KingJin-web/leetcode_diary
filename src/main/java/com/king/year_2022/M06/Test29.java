package com.king.year_2022.M06;

import com.king.util.MyPrint;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年06月29日 00:24
 * @description: 535. TinyURL 的加密与解密
 */
public class Test29 {
    //535. TinyURL 的加密与解密
    //    public String encode(String longUrl) {
    //        return "http://tinyurl.com/" + longUrl.hashCode();
    //    }
    //    public String decode(String shortUrl) {
    //        return shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
    //    }
    private static class Codec {

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            return longUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return shortUrl;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        MyPrint.print(codec.encode("https://leetcode.com/problems/design-tinyurl"));
        MyPrint.print(codec.decode("https://leetcode.com/problems/design-tinyurl"));
    }
}
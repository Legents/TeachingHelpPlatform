package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

public class MD5Util {
    private static final String salt = "1a2b3c";
    //是否开启加密,开发时可以不开启，开发完后开启
    private static boolean flag = false;

    public static String md5(String str) {
        if (!flag) return str;
        //加密前先打乱密码，防止通过暴力破解的方式反推出密码
        str = salt.charAt(0) + salt.charAt(1) + str + salt.charAt(4) + salt.charAt(3);
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(md5("123"));
    }


}

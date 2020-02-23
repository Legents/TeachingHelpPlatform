package com.example.demo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static String getCookie(HttpServletRequest request, String cookieName) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void printCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            System.out.println("cookie------------------start");
            for (Cookie cookie : cookies) {
                System.out.println(String.format("%s:%s", cookie.getName(), cookie.getValue()));
            }
            System.out.println("cookie------------------end");
        }

    }

    public static void setCookie(HttpServletResponse response, String cookieName, String value, int cookieMaxAge) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        cookie.setMaxAge(cookieMaxAge);
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse response, String cookieName) {
        setCookie(response, cookieName, null, 0);
    }
}

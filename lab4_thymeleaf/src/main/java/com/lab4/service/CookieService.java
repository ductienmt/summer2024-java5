package com.lab4.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    public Cookie get(String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public String getValue(String name) {
        Cookie cookie = get(name);
        return cookie != null ? cookie.getValue() : "";
    }

    public Cookie add(String name, String value, int hours) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 3600); // Set expiration time in seconds
        cookie.setPath("/"); // Set cookie path
        response.addCookie(cookie);
        return cookie;
    }

    public void remove(String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0); // Set the cookie's age to 0 to delete it
        cookie.setPath("/"); // Ensure the path matches the cookie to be deleted
        response.addCookie(cookie);
    }
}

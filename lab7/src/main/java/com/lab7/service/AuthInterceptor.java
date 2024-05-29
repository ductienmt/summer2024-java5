package com.lab7.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class AuthInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();

        // Check if the user is logged in
        if (session.getAttribute("user") == null) {
            if (requestURI.startsWith("/account/edit") ||
                    requestURI.startsWith("/account/chgpwd") ||
                    requestURI.startsWith("/order/") ||
                    !requestURI.startsWith("/assets/")) {
                response.sendRedirect("/account/login?message=You must be logged in to access this page");
                return false;
            }
        }

        // Check if the user is an admin
        if (session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            if (requestURI.startsWith("/admin") && !requestURI.startsWith("/admin/home/index")) {
                response.sendRedirect("/account/login?message=You must be an admin to access this page");
                return false;
            }
        }

        return true;
    }
}

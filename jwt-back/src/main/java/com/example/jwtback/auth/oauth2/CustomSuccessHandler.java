package com.example.jwtback.auth.oauth2;

import com.example.jwtback.auth.jwt.JWTUtil;
import com.example.jwtback.auth.oauth2.dto.CustomOAuth2User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JWTUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //OAuth2User
        CustomOAuth2User customUserDetails = (CustomOAuth2User) authentication.getPrincipal();

        String username = customUserDetails.getUsername();

        String role = authentication.getAuthorities().iterator().next().getAuthority();

        String token = jwtUtil.createJwt(username, role, 600000L);

        response.addCookie(createCookie("Authorization", token));
        response.sendRedirect("http://localhost:3000/main");
    }

    private Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 10); // 10분
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        // https 사용시 설정
        // cookie.setSecure(true);
        return cookie;
    }
}
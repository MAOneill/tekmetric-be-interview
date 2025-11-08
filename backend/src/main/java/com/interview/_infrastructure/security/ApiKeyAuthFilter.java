package com.interview._infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview._infrastructure.exceptions.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class ApiKeyAuthFilter extends OncePerRequestFilter {

    private final String headerName;
    private final String expectedApiKey;
    private final ObjectMapper objectMapper = new ObjectMapper(); // simple for demo


    public ApiKeyAuthFilter(String headerName, String expectedApiKey) {
        this.headerName = headerName;
        this.expectedApiKey = expectedApiKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String apiKey = request.getHeader(headerName);

        if (apiKey == null || !apiKey.equals(expectedApiKey)) {
            CustomError error = new CustomError("You do not have access to this resource!",
                    HttpStatus.UNAUTHORIZED,
                    request.getRequestURI());
            // Reject immediately
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            objectMapper.writeValue(response.getWriter(), error);

            return;

        }
        Authentication auth = new UsernamePasswordAuthenticationToken(
                "api-key-user",
                null
        ,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }
}

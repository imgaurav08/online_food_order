package com.foodify.user_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.persistence.Column;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

      String header =  request.getHeader("Authorization");
if (header!=null && header.startsWith("Bearer ")){
     String token = header.substring(7);

  Claims claims =  Jwts.parserBuilder().setSigningKey(secret.getBytes())
          .build()
          .parseClaimsJws(token)
          .getBody();

  String email = claims.getSubject();

    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,null, List.of());
    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
}
filterChain.doFilter(request,response);
    }
}

package com.example.springsecuirtybest.securtiy.filter;

import com.example.springsecuirtybest.domain.User;
import com.example.springsecuirtybest.service.impl.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         User loginUser = tokenService.getLoginUser(request);
        System.out.println("sb1"+loginUser);
         if (loginUser!=null&& SecurityContextHolder.getContext().getAuthentication()==null){
             tokenService.verifyToken(loginUser);
             System.out.println("sb"+loginUser);
             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(loginUser,null, loginUser.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));//用户信息
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
         }
         filterChain.doFilter(request, response);
    }
}

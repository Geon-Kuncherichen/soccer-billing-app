package com.soccer_bill_splitter.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.soccer_bill_splitter.service.CustomUserDetailService;
import com.soccer_bill_splitter.util.JwtUtil;


@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader=request.getHeader("Authorization");
		if(!StringUtils.isEmpty(authorizationHeader)&&authorizationHeader.startsWith("Bearer "))
		{
			authorizationHeader=authorizationHeader.substring(7);
			String userName=jwtUtil.extractUsername(authorizationHeader);
			
			if(!StringUtils.isEmpty(userName))
			{
				UserDetails userDetails=customUserDetailService.loadUserByUsername(userName);
				if(userDetails.getUsername().equalsIgnoreCase("NOTHING")&&userDetails.getPassword().equalsIgnoreCase("NOTHING"))
				{
					response.setStatus(401);
					return;
				}
				if (jwtUtil.validateToken(authorizationHeader, userDetails)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
			}
		
			
			
		}
		filterChain.doFilter(request, response);
		
	}

}

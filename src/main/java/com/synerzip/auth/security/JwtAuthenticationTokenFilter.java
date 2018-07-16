package com.synerzip.auth.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Value("${jwt.header}")
	private String tokenHeader;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		String authToken = request.getHeader(this.tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(authToken);
		logger.debug("checking authentication for user " + username);
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			if (jwtTokenUtil.validateToken(authToken)) {
				UserDetails userDetails = null;
				try {
					userDetails = jwtTokenUtil.getUserDetails(authToken);
				} catch (Exception ex) {
					logger.error("Error while getting user details from token due to: " + ex.getMessage(), ex);
					response.sendError(HttpStatus.BAD_REQUEST.value(), "Error while getting user details from token due to: " + ex.getMessage());
				}
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authenticated user " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}
}
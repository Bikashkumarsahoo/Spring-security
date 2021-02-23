package com.example.springsecurityjwt.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm; 

public class JwtUtil {

	private final String KEY = "ABCDEF";
	
	public String extractUsername(String token)
	{
		return extractClaim(token,Claims::getSubject);
	}
	private Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	private <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
		final Claims claims=extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	private Claims extractAllClaims(String token)
	{
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}
	private Boolean isTokenExpired(String token)
	{
		return extractExpiration(token).before(new Date());
	}
	

	private String generateToken(UserDetails userDetails)
	{
		Map<String,Object> claims=new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}
	private String createToken(Map<String, Object> claims,String subject) {
		
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS256, KEY).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails)
	{
		final String username= extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

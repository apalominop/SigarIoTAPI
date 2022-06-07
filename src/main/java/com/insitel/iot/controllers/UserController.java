package com.insitel.iot.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.insitel.iot.models.User;
import com.insitel.iot.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * Servicio para validar el User Login y generar el Token
	 * @param username
	 * @param pwd
	 * @return
	 */
	@PostMapping("user")
	public ResponseEntity<User> login(@RequestParam("user") String username, 
			@RequestParam("password") String pwd) {
		
		try {
			User user = new User();
			user.setNombre(username);
			user.setPassword(pwd);
			
			Optional<User> encontrado = userService.verificarUser(user);
			if (encontrado.isPresent()) {
				User us = encontrado.get();
				String token = getJWTToken(username);
				user.setToken(token);
				user.setId(us.getId());
				user.setEmail(us.getEmail());
				return ResponseEntity.ok(user);
			} 
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	private String getJWTToken(String username) {
		String secretKey = "insitel13579iot";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 36000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
}

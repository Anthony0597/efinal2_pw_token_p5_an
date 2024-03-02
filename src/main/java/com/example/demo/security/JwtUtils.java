package com.example.demo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	public String buildTokenJwt(String nombre, String semilla, int tiempo) {
		return Jwts.builder().setSubject(nombre).setSubject("Hola numdo").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + tiempo))
				.signWith(SignatureAlgorithm.HS512,semilla)
				.compact();
	}
}

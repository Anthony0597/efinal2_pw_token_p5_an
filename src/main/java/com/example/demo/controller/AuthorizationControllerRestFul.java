package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtils;
import com.example.demo.service.to.UsuarioTO;

@RestController
@RequestMapping("/autorizaciones")
public class AuthorizationControllerRestFul {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwt;
	
	@GetMapping(path = "/jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtenetToken(@RequestBody UsuarioTO user) {
		this.autenticacion(user.getNombre(), user.getPassword());
		return this.jwt.buildTokenJwt(user.getNombre(),"",0);
	}

	private void autenticacion(String usuario, String password) {
		UsernamePasswordAuthenticationToken usuarioToken=new UsernamePasswordAuthenticationToken(usuario, password); 
		
		Authentication autenticacion=this.authenticationManager.authenticate(usuarioToken);
		SecurityContextHolder.getContext().setAuthentication(autenticacion);
	}
	
}

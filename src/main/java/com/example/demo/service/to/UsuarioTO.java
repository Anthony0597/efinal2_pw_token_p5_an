package com.example.demo.service.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable{
	
	private static final long serialVersionUID = -8680871064519804975L;
	private String nombre;
	private String password;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

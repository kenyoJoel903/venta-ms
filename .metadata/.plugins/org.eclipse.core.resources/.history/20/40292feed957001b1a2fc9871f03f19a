package com.kenyo.tienda.model;


import java.util.List;

import com.kenyo.tienda.domain.Cliente;

public class JwtDto {
	
	private Cliente usuario;
	private String accessToken;
	private String tokenType;
	
	public JwtDto() {}
	
	public JwtDto(String jwt, Cliente usuario, List<String> roles) {
		this.accessToken = jwt;
		this.usuario = usuario;
		this.tokenType = "Bearer";
	}

	public Cliente getUsuario() {
		return usuario;
	}

	public void setUsuario(Cliente usuario) {
		this.usuario = usuario;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
	
	

}

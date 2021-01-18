package com.kenyo.auth.model;


import java.util.List;


public class JwtDto {
	
	private Usuario usuario;
	private String accessToken;
	private String tokenType;
	
	public JwtDto() {}
	
	public JwtDto(String jwt, Usuario usuario, List<String> roles) {
		this.accessToken = jwt;
		this.usuario = usuario;
		this.tokenType = "Bearer";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
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

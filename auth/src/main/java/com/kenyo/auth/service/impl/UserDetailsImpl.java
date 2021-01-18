package com.kenyo.auth.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kenyo.auth.model.Usuario;

public class UserDetailsImpl implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2587822711706125669L;

	private Long id;

	private String nick;
	
	private String nombre;
	
	private String apellido;
	
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;


	public UserDetailsImpl(Long id, String nick, String password, String nombre,
			String apellido, 
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.nick = nick;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Usuario usuario) {
		SimpleGrantedAuthority CLIENTE_ROLE = new SimpleGrantedAuthority("USUARIO_ROLE");
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(CLIENTE_ROLE);

		return new UserDetailsImpl(
				usuario.getId(),  
				usuario.getNick(),
				usuario.getClave(), 
				usuario.getNombres(),
				usuario.getApellidos(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return nick;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}

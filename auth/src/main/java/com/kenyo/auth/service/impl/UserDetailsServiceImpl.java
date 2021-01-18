package com.kenyo.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kenyo.auth.model.Usuario;
import com.kenyo.auth.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNick(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no ecnontrado con nick: " + username));
		return UserDetailsImpl.build(usuario);
	}
}

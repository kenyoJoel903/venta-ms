package com.kenyo.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kenyo.tienda.domain.Cliente;
import com.kenyo.tienda.repository.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Cliente cliente = clienteRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no ecnontrado con email: " + username));
		return UserDetailsImpl.build(cliente);
	}
}

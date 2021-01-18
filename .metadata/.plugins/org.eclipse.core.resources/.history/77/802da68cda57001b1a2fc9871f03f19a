package com.kenyo.tienda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.tienda.model.LoginDto;
import com.kenyo.tienda.service.AutenticacionService;


@Controller
@RestController
@RequestMapping("/api/auth")
public class AutenticacionController {
	
	@Autowired
	private AutenticacionService autenticacionService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
		return ResponseEntity.ok(autenticacionService.autenticar(loginDto));
	}

}

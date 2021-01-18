package com.kenyo.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.auth.model.LoginDto;
import com.kenyo.auth.service.AutenticacionService;



@Controller
@RestController
@RequestMapping("/security")
public class AutenticacionController {
	
	@Autowired
	private AutenticacionService autenticacionService;
	
	@PostMapping
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
		System.out.println(loginDto.toString());
		return ResponseEntity.ok(autenticacionService.autenticar(loginDto));
	}

}

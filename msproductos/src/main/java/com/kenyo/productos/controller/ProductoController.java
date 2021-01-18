package com.kenyo.productos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.productos.model.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@GetMapping
	public Producto test() {
		System.out.println("ssssssss");
		Producto p = new Producto();
		p.setNombre("aaaaaaa");
		return p;
	}

}

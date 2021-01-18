package com.kenyo.productos.service;

import java.util.List;

import com.kenyo.productos.model.Producto;

public interface ProductoService {
	
	Producto registrar(Producto producto);
	Producto actualizar(Producto producto);
	Producto buscarPorId(long id);
	List<Producto> listarTodos();
	List<Producto> listarPorVendedor(long idVendedor);
	List<Producto> listarPendientesVender();
	void eliminar(long id);

}

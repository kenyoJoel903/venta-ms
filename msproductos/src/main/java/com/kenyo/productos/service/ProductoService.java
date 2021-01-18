package com.kenyo.productos.service;

import java.util.List;

import com.kenyo.productos.model.Producto;

public interface ProductoService {
	
	Producto registrar(Producto producto, String usuarioRegistra);
	Producto actualizar(Producto producto, String usuarioModifica);
	Producto buscarPorId(long id);
	List<Producto> listarTodos();
	List<Producto> listarPorVendedor(String vendedor);
	List<Producto> listarPendientesVender();
	void eliminar(long id);
	
	Producto marcarComoVendido(long idProducto, String usuarioVendedor);
	Producto marcarComoPerdido(long idProducto, String usuarioModifica);

}

package com.kenyo.productos.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.productos.exceptions.VentaException;
import com.kenyo.productos.model.Producto;
import com.kenyo.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	public Producto registrar(Producto producto) {
		producto.setVendido(false);
		producto.setRobadoPerdido(false);
		producto.setFechaCreacion(new Date());
		return repository.save(producto);
	}

	@Override
	public Producto actualizar(Producto producto) {
		producto.setFechaModificacion(new Date());
		return repository.save(producto);
	}

	@Override
	public Producto buscarPorId(long id) {
		Optional<Producto> opt = repository.findById(id);
		if(opt.isPresent())
			throw new VentaException("No se encuentra el producto " + id);
		return opt.get();
	}

	@Override
	public List<Producto> listarTodos() {
		return repository.findAll();
	}

	@Override
	public List<Producto> listarPorVendedor(long idVendedor) {
		return repository.buscarPorVendedor(idVendedor);
	}

	@Override
	public List<Producto> listarPendientesVender() {
		return repository.listarProductosPendienteVender();
	}

	@Override
	public void eliminar(long id) {
		Optional<Producto> opt = repository.findById(id);
		if(opt.isPresent())
			throw new VentaException("No se encuentra el producto " + id);
		repository.deleteById(id);
		
	}

}

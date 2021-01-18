package com.kenyo.productos.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.productos.exceptions.ModelNotFoundException;
import com.kenyo.productos.exceptions.VentaException;
import com.kenyo.productos.model.Producto;
import com.kenyo.productos.model.Usuario;
import com.kenyo.productos.repository.ProductoRepository;
import com.kenyo.productos.repository.UsuarioRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Override
	public Producto registrar(Producto producto, String usuarioRegistra) {
		if(repository.existsByNombre(producto.getNombre().toUpperCase()))
			throw new VentaException("Ya existe un producto registrado con el nombre " + producto.getNombre());
		producto.setNombre(producto.getNombre().toUpperCase());
		producto.setVendido(false);
		producto.setRobadoPerdido(false);
		producto.setFechaCreacion(new Date());
		producto.setUsuarioCreacion(buscarUsuario(usuarioRegistra));
		return repository.save(producto);
	}

	@Override
	public Producto actualizar(Producto producto, String usuarioModifica) {
		Producto productoAnterior = buscarPorId(producto.getId());
		productoAnterior.setPrecio(producto.getPrecio());
		productoAnterior.setNombre(producto.getNombre().toUpperCase());
		productoAnterior.setRobadoPerdido(producto.isRobadoPerdido());
		productoAnterior.setFechaModificacion(new Date());
		productoAnterior.setUsuarioModificacion(buscarUsuario(usuarioModifica));
		return repository.save(productoAnterior);
	}

	@Override
	public Producto buscarPorId(long id) {
		Optional<Producto> opt = repository.findById(id);
		if(!opt.isPresent())
			throw new VentaException("No se encuentra el producto " + id);
		return opt.get();
	}

	@Override
	public List<Producto> listarTodos() {
		return repository.findAll();
	}

	@Override
	public List<Producto> listarPorVendedor(String vendedor) {
		return repository.buscarPorVendedor(buscarUsuario(vendedor).getId());
	}

	@Override
	public List<Producto> listarPendientesVender() {
		return repository.listarProductosPendienteVender();
	}

	@Override
	public void eliminar(long id) {
		Optional<Producto> opt = repository.findById(id);
		if(!opt.isPresent())
			throw new VentaException("No se encuentra el producto " + id);
		repository.deleteById(id);
		
	}
	
	@Override
	public Producto marcarComoVendido(long idProducto, String usuarioVendedor) {
		Producto producto = buscarPorId(idProducto);
		if(producto.isVendido())
			throw new VentaException("El producto " + producto.getNombre() + " ha sido registrado como vendido anteriormente");
		if(producto.isRobadoPerdido())
			throw new VentaException("El producto " + producto.getNombre() + " ha sido registrado como perdido/robado anteriormente");
		Usuario vendedor = buscarUsuario(usuarioVendedor);
		producto.setFechaModificacion(new Date());
		producto.setUsuarioVendedor(vendedor);
		producto.setUsuarioModificacion(vendedor);
		producto.setVendido(true);
		return repository.save(producto);
	}

	@Override
	public Producto marcarComoPerdido(long idProducto, String usuarioModifica) {
		Producto producto = buscarPorId(idProducto);
		if(producto.isVendido())
			throw new VentaException("El producto " + producto.getNombre() + " ha sido registrado como vendido anteriormente");
		Usuario usuarioMod = buscarUsuario(usuarioModifica);
		producto.setFechaModificacion(new Date());
		producto.setUsuarioModificacion(usuarioMod);
		producto.setRobadoPerdido(true);
		return repository.save(producto);
	}
	
	private Usuario buscarUsuario(String nick) {
		Optional<Usuario> optUsuario = repositoryUsuario.findByNick(nick);
		if(!optUsuario.isPresent())
			throw new ModelNotFoundException("No existe usuario " + nick);
		return optUsuario.get();
	}



}

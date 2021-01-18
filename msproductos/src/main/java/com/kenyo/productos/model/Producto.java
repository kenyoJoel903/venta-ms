package com.kenyo.productos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kenyo.productos.util.Constant;

@Entity
@Table(name = "productos", 
 uniqueConstraints = {
		 @UniqueConstraint(columnNames = "nombre")
 })
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(precision = 5, scale = 2, nullable = false)
	private double precio;
	
	@Column(nullable = false)
	private boolean vendido;
	
	@Column(nullable = false)
	private boolean robadoPerdido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FORMATO_FECHA_HORA)
	@Column(nullable = false)
	private Date fechaCreacion;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "usuarioCreacion")
	private Usuario usuarioCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FORMATO_FECHA_HORA)
	@Column(nullable = true)
	private Date fechaModificacion;
	
	@ManyToOne
	@JoinColumn(nullable = true, name = "usuarioModificacion")
	private Usuario usuarioModificacion;
	
	@ManyToOne
	@JoinColumn(nullable = true, name = "idVendedor")
	private Usuario usuarioVendedor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public boolean isRobadoPerdido() {
		return robadoPerdido;
	}

	public void setRobadoPerdido(boolean robadoPerdido) {
		this.robadoPerdido = robadoPerdido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Usuario getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Usuario getUsuarioVendedor() {
		return usuarioVendedor;
	}

	public void setUsuarioVendedor(Usuario usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}


	
	

}

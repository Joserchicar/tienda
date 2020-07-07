package com.ipartek.formacion.modelo.pojo;

import java.sql.ResultSet;

public class Fabricante {

	private int codigo;
	private String nombre;
	
	public Fabricante() {
		super();
		this.codigo = 0;
		this.nombre = "";
	}

	public int getId() {
		return codigo;
	}

	public void setId(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
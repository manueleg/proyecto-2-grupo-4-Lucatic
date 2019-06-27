package com.spring.model;

import java.time.LocalDate;

/**
 * @author grupo4
 * Clase modelo "Perfil"
 */

import java.util.ArrayList;

public class Perfil {
	
	/**
	 * Atributos
	 */
	 private int id;
	 private String name;
	 private Genero genero;
	 private LocalDate fechaNac;
	 private String poblacion;
	 private int intereses;
	 private String descripcion;
	 
	 /**
	  * constructores
	  */
	public Perfil() {
		super();
	}

	public Perfil(int id, String name, Genero genero, LocalDate fechaNac, String poblacion, int intereses,
			String descripcion) {
		super();
		this.id = id;
		this.name = name;
		this.genero = genero;
		this.fechaNac = fechaNac;
		this.poblacion = poblacion;
		this.intereses = intereses;
		this.descripcion = descripcion;
	}
	
	/**
	  * getter y setter
	  */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getIntereses() {
		return intereses;
	}

	public void setIntereses(int intereses) {
		this.intereses = intereses;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	 
	
	
	
	 
}

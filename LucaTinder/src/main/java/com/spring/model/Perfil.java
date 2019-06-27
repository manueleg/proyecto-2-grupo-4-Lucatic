package com.spring.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Perfil {
	 private String name;
	 private String genero;
	 private String poblacion;
	 private ArrayList<String>intereses;
	 private String descripcion;
	 private LocalDate fechaNac;
	 
	public Perfil() {
		super();
	}

	public Perfil(String name, String genero, String poblacion, ArrayList<String> intereses, String descripcion,
			LocalDate fechaNac) {
		super();
		this.name = name;
		this.genero = genero;
		this.poblacion = poblacion;
		this.intereses = intereses;
		this.descripcion = descripcion;
		this.fechaNac = fechaNac;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public ArrayList<String> getIntereses() {
		return intereses;
	}

	public void setIntereses(ArrayList<String> intereses) {
		this.intereses = intereses;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nPerfil \nName: ");
		builder.append(name);
		builder.append("\nGenero: ");
		builder.append(genero);
		builder.append("\nPoblacion: ");
		builder.append(poblacion);
		builder.append("\nIntereses: ");
		builder.append(intereses);
		builder.append("\nDescripcion: ");
		builder.append(descripcion);
		builder.append("\nFecha de nacimiento: ");
		builder.append(fechaNac);
		return builder.toString();
	}
	
	
	 
}

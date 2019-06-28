package com.spring.model;

import java.time.LocalDate;

/**
 * @author grupo4
 * Clase modelo "Perfil"
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="usuarios")
public class Perfil {
	
	/**
	 * Atributos
	 */
	 private int idusuario;
	 private String nombre;
	 private Genero genero;
	 private LocalDate edad;
	 private String poblacion;
	 private int idintereses;
	 private String descripcion;
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "idusuario")
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public LocalDate getEdad() {
		return edad;
	}
	public void setEdad(LocalDate edad) {
		this.edad = edad;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getIdintereses() {
		return idintereses;
	}
	public void setIdintereses(int idintereses) {
		this.idintereses = idintereses;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	
	 

}
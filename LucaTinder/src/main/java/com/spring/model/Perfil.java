package com.spring.model;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author grupo4
 * Clase modelo "Perfil"
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.github.javafaker.Faker;

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

	public Perfil crearPerfilFaker() {

		int id;
		String name;
		Genero genero;
		Date fechaNac;
		LocalDate fecha;
		String poblacion;
		int intereses;
		String descripcion;
		Faker faker = new Faker(new Locale("es-ES"));
		Perfil p;

		id = faker.number().randomDigitNotZero();
		name = faker.harryPotter().character();
		if (faker.number().numberBetween(0, 1) == 0) {
			genero = Genero.H;
		} else {
			genero = Genero.M;
		}
		fechaNac = faker.date().birthday();
		fecha = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		poblacion = faker.address().cityName();
		intereses = faker.number().randomDigitNotZero();
		descripcion = faker.lorem().paragraph(4);

		p = new Perfil(id, name, genero, fecha, poblacion, intereses, descripcion);

		return p;
	}

}

package com.spring.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.github.javafaker.Faker;

@Entity
@Table(name = "usuarios")
public class Perfil {
	/**
	 * Atributos
	 */
	private int idusuario;
	private String nombre;
	private Genero genero;
	private LocalDate edad;
	private String poblacion;
	private Integer idintereses;
	private String descripcion;

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(Perfil.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	
	/**
	 * Constructor por defecto
	 */
	public Perfil() {
		super();
		logger.info("-------Perfil Perfil");
	}

	/**
	 * Constructor por parámetros
	 * @param idusuario
	 * @param nombre
	 * @param genero
	 * @param edad
	 * @param poblacion
	 * @param idintereses
	 * @param descripcion
	 */
	public Perfil(int idusuario, String nombre, Genero genero, LocalDate edad, String poblacion, Integer idintereses,
			String descripcion) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.poblacion = poblacion;
		this.idintereses = idintereses;
		this.descripcion = descripcion;
		logger.info("-------Perfil Perfil(param)");
	}
	
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

	public Character getGenero() {
		return (char) genero.getCharGenero();
	}

	public void setGenero(Character genero) {
		if(genero.equals('h')) {
			this.genero = Genero.H;
		}else {
			this.genero = Genero.M;
		}
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

	public Integer getIdintereses() {
		return idintereses;
	}

	public void setIdintereses(Integer idintereses) {
		this.idintereses = idintereses;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perfil [idusuario=");
		builder.append(idusuario);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", edad=");
		builder.append(edad);
		builder.append(", poblacion=");
		builder.append(poblacion);
		builder.append(", idintereses=");
		builder.append(idintereses);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * Metodo para generar objetos de la clase perfil mediante la librería JavaFaker
	 * @return Perfil
	 */
	/*public Perfil crearPerfilFaker() {

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
		
		logger.info("-------Perfil crearPerfilFaker");

		return p;
	}*/
	
	
}


package com.spring.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;

import com.github.javafaker.Faker;


@Entity
@Table(name = "usuarios")
public class Perfil {
	/**
	 * Atributos
	 */
	private int idusuario;
	private String nombre;
	private String genero;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha_nac;
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
	public Perfil(int idusuario, String nombre, String genero, LocalDate fecha_nac, String poblacion, Integer idintereses,
			String descripcion) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.genero = genero;
		this.fecha_nac = fecha_nac;
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

	public String getGenero() {
		return genero;
	}
	/*
	public Genero getGenero() {
		return genero;
	}*/
	
	public void setGenero(String genero) {
		this.genero=genero;
		/*if(genero.equals('h')) {
			this.genero = Genero.H;
		}else {
			this.genero = Genero.M;
		}*/
	}
/*
	public void setGenero(Genero genero) {
	this.genero = genero;
    }
*/
	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
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
		builder.append(", fecha_nac=");
		builder.append(fecha_nac);
		builder.append(", poblacion=");
		builder.append(poblacion);
		builder.append(", idintereses=");
		builder.append(idintereses);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha_nac == null) ? 0 : fecha_nac.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((idintereses == null) ? 0 : idintereses.hashCode());
		result = prime * result + idusuario;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha_nac == null) {
			if (other.fecha_nac != null)
				return false;
		} else if (!fecha_nac.equals(other.fecha_nac))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (idintereses == null) {
			if (other.idintereses != null)
				return false;
		} else if (!idintereses.equals(other.idintereses))
			return false;
		if (idusuario != other.idusuario)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		return true;
	}
	
	

	/**
	 * Metodo para generar objetos de la clase perfil mediante la librería JavaFaker
	 * @return Perfil
	 */
	public void crearPerfilFaker() {

		/*int id;
		String name;
		Genero genero;
		Date fechaNac;
		LocalDate fecha;
		String poblacion;
		int intereses;
		String descripcion;*/
		Faker faker = new Faker(new Locale("es-ES"));

		this.nombre=faker.lordOfTheRings().character();
		if(faker.random().nextBoolean()) {
			this.genero="h";
		}else {
			this.genero="m";
		}
        /*
		this.fecha_nac = faker.date(pattern="%Y-%m-%d", end_datetime=None);
		faker.random()
		Instant instant = faker.date().toInstant();
		String streetName = faker.address().streetName();
		String number = faker.address().buildingNumber();
		String city = faker.address().city();
		String country = faker.address().country();

		Hopefully thi
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate fecha_nac;
		private String poblacion;
		private Integer idintereses;
		private String descripcion;
		
		System.out.println(String.format("%s\n%s\n%s\n%s",
		  number,
		  streetName,
		  city,
		  country));*/
		/*
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
*/
	}
	
	public int dameEdad() {
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(this.fecha_nac, ahora);
		return periodo.getYears();
	}
}


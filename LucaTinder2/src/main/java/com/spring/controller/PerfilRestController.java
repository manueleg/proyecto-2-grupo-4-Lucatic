package com.spring.controller;


import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Perfil;
import com.spring.services.PerfilService;

//SI TENGO DUDAS CON EL REST MIRAR EN SERVICIOS DE ANGULAR (VISUAL STUDIO)

@CrossOrigin(origins = "*", maxAge = 3600)//he puesto esta notacion porque cuando usemos angular es obligatoria
@RestController
@RequestMapping({"/indexrest"})
public class PerfilRestController {
	
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(PerfilRestController.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	private final PerfilService service;

	@Autowired
	public PerfilRestController(PerfilService service) {
		super();
		this.service = service;
	}
	
	/**
	 * readPerfiles un método creado para devolver los perfiles 
	 * @param perfil
	 * @return lista de todos los perfiles
	 */
	@GetMapping("/readperfiles")
	Collection<Perfil> readPerfiles(Perfil perfil){
		return this.service.getPerfiles(perfil);
	}

	/**
	 * método que recoge un perfil segun su id
	 * @param id
	 * @return perfil
	 */
	@GetMapping("/{id}")
	Perfil readPerfil(@PathVariable int id) {
		if(this.service.get(id)!=null) {
			return this.service.get(id);
		}
		return null;
	}

	/**
	 * metodo para añadir un perfil. se consigue por su id concreto
	 * @param perfil
	 */
	@PostMapping
	public void addPerfil(@RequestBody Perfil perfil) {
		this.service.add(perfil);
	}
	
	/**
	 * método que elimina un perfil segun su id
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deletePerfil(@PathVariable int id) {
		this.service.delete(id);
	}
	
	/**
	 * Método que añade like
	 * @param id
	 */
	@GetMapping(path = { "/{id1}/{id2}" })
	public void addLike(@PathVariable("id1") int id1,@PathVariable("id2") int id2 ) {
		this.service.like(id1, id2);
	}
	
	/**
	 * Recibe por parámetro el id del perfil que se ha logueado y devuelve un list de los perfiles con los que
	 * el perfil logueado ha tenido match.
	 * @param int id1
	 * @return list de objetos tipo Perfil
	 */
	@GetMapping("/listMatches/{id1}")
	public Collection<Perfil> matches(@PathVariable("id1") int id1) {
		logger.info("----Recogiendo listado de matches y enviando a matches.html");
		return this.service.getPerfilesMatch(service.get(id1)) ;
	}
	
	@PutMapping
	public void updatePerfil(@RequestBody Perfil perfil) {
		this.service.update(perfil);
	}

}

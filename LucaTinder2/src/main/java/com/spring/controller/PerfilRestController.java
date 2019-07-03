package com.spring.controller;


import java.util.Collection;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.repository.PerfilRepository;
import com.spring.services.PerfilService;
import com.spring.model.Perfil;
import org.springframework.web.bind.annotation.PutMapping;
import antlr.collections.List;

@CrossOrigin(origins = "*", maxAge = 3600)//he puesto esta notacion porque cuando usemos angular es obligatoria
@RestController
@RequestMapping({"/indexrest"})
public class PerfilRestController {
	
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
	@GetMapping
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
		return this.service.get(id);
	}

	/**
	 * metodo para añadir un perfil. se consigue por su id concreto
	 * @param perfil
	 */
	@PostMapping("/{id}")
	public void addPerfil(@RequestBody Perfil perfil) {
		this.service.add(perfil);
	}

	
	
}

package com.spring.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Perfil;
import com.spring.services.PerfilServices;

/* 
* @author grupo4
* @version 1.0 27/06/2019
* Clase con la anotación @Controller. Es un controlador y pertenece a la capa de presentación.
*/

@Controller
public class PerfilController {

	@Autowired
	private PerfilServices perfilServices;
	
	/**
	 * Instancia del Logger
	 */
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(PerfilController.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	
	/**
	 * pasamos el listado de valores que hemos creado en la interfaz de Servicios
	 * @param model
	 * @return index.html
	 * @throws Exception
	 */
	
	@RequestMapping("/index")
	public String handleRequest(ModelMap model) throws Exception{ 
		logger.info("---HandleRequest");
		model.addAttribute("listadoperfiles", perfilServices.getPerfiles());
		return "index";
	}
	
	/**
	 * Recibe por parámetro un objeto de tipo Perfil y lo guardará en la base de datos. 
	 * Devuelve la ruta para ir a la página contactos.html
	 * @param Perfil perfil
	 * @return contactos
	 */
	@PostMapping("/save")
	public String registroPerfil(@ModelAttribute Perfil perfil) {
		logger.info("-- en método registroPerfil");
		perfilServices.add(perfil);
		return "contactos";
	}
	
	/**
	 * Método login que comprueba si el usuario existe y le deja entrar en la página o no
	 * @param perfil
	 * @param listPerfiles
	 * @return contactos e index
	 */
	
	@PostMapping("/acceso")
	public String login(@ModelAttribute Perfil perfil, ModelMap listPerfiles) {
		logger.info("----COMPROBANDO IDs");
		if(perfilServices.get(perfil.getIdusuario())!=null) {
			listPerfiles.addAttribute(perfil);
			listPerfiles.addAttribute("perfil", perfilServices.generarPerfiles());
			return "contactos";
		}else {
			return "index";
		}
	}
	
	/**
	 * Método like que recibe los likes del usuario
	 * @param id1
	 * @param id2
	 * @return redirect
	 */
	@PostMapping("/contactos")
	public String like(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		logger.info("----RECIIENDO IDs -> /LIKE");
		perfilServices.like(id1, id2);
		return ":/redirect";
	}
	
	
}

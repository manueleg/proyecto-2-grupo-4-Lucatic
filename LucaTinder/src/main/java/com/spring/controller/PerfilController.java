package com.spring.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("listadoperfiles", perfilServices.list());
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
		logger.info("-- en método registroPerfil de la clase PerfilController");
		perfilServices.add(perfil);
		return "contactos";
	}
	
}

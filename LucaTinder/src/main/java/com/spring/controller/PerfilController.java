package com.spring.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String registroPerfil(@ModelAttribute Perfil perfil, ModelMap model) {
		logger.info("-- en método registroPerfil");
		perfilServices.add(perfil);
		model.addAttribute("perfil", perfil);
		model.addAttribute("perfilList", perfilServices.getPerfiles());
		return "contactos";
	}
	
	/**
	 * Método login que comprueba si el usuario existe y le deja entrar en la página o no
	 * @param perfil
	 * @param model
	 * @return contactos e index
	 */
	
	@PostMapping("/acceso")
	public String login(@ModelAttribute Perfil perfil, ModelMap model) {
		logger.info("----COMPROBANDO IDs");
		if(perfilServices.get(perfil.getIdusuario())!=null) {
			model.addAttribute("perfil", perfil);
			model.addAttribute("perfilList", perfilServices.getPerfiles());
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
	@PostMapping("/like")
	public String like(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		logger.info("----RECIIENDO IDs -> /LIKE");
		perfilServices.like(id1, id2);
		return "redirect:/contactos";
	}
	
	/**
	 * Método que envía la información del dislike para guardarla en la base de datos
	 * @param idPerfil
	 * @param idDislike
	 * @return contactos
	 */
	@GetMapping("/dislike")
	public String dislike(@RequestParam("idperfil") int idPerfil, @RequestParam("iddislike") int idDislike) {
		perfilServices.dislike(idPerfil, idDislike);
		logger.info("-------PerfilController dislike");
		return "contactos";
	}
	
	/**
	 * Método que envía la información de los intereses para guardarlos en la base de datos
	 * @param idPerfil
	 * @param genero
	 * @param edadMin
	 * @param edadMax
	 * @return perfil
	 */
	@GetMapping("/guardarintereses")
	public String guardarIntereses(@RequestParam("idperfil") int idPerfil, @RequestParam("genero") String genero,@RequestParam("edadMin") int edadMin,@RequestParam("edadMax") int edadMax) {
		perfilServices.guardarIntereses(idPerfil, genero, edadMin, edadMax);
		logger.info("-------PerfilController guardarIntereses");
		return "perfil";
	}
	
}

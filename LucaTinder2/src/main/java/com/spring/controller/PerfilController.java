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
import com.spring.services.PerfilService;


@Controller
public class PerfilController {

	@Autowired
	private PerfilService perfilService;
	
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(PerfilController.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}

	/**
	 * Metodo para acceder a la pagina index pasandole un objeto perfil
	 * @param model
	 * @return index.html
	 * @throws Exception
	 */
	
	@RequestMapping("/")
	public String handleRequest(ModelMap model) throws Exception{ 
		logger.info("---HandleRequest");
		model.addAttribute("perfil", new Perfil());
		return "index";
	}
	
	/**
	 * Método para acceder a la página registro pasandole un objeto perfil
	 * @param model
	 * @return index.html
	 * @throws Exception
	 */
	
	@RequestMapping("/registro")
	public String handleRequest1(ModelMap model) throws Exception{ 
		logger.info("---HandleRequest");
		model.addAttribute("perfil", new Perfil());
		return "registro";
	}
	
	/**
	 * Recibe por parámetro un objeto de tipo Perfil y lo guardará en la base de datos. 
	 * Devuelve la ruta para ir a la página contactos.html
	 * @param Perfil perfil
	 * @return contactos
	 */
	@PostMapping("/save")
	public String registroPerfil(@ModelAttribute("perfil") Perfil perfil, ModelMap model) {
		logger.info("-- en método registroPerfil");
		perfilService.add(perfil);
		model.addAttribute("perfil", perfil);
		model.addAttribute("perfilList", perfilService.getPerfiles(perfil));
		return "contactos";
	}
	
	/**
	 * Método login que comprueba si el usuario existe y le deja entrar en la página o no
	 * @param perfil
	 * @param model
	 * @return contactos e index
	 */
	
	@PostMapping("/acceso")
	public String login(@ModelAttribute("perfil") Perfil perfil, ModelMap model) {
		logger.info("----COMPROBANDO IDs");
		if(perfilService.get(perfil.getIdusuario())!=null) {
			perfil=perfilService.get(perfil.getIdusuario());
			model.addAttribute("perfil", perfil);
			model.addAttribute("perfilList", perfilService.getPerfiles(perfil));
			return "contactos";
		}else {
			model.addAttribute("perfil", perfil);
			return "index";
		}
	}
	
	/**
	 * Método like que recibe los likes del usuario
	 * @param id1
	 * @param id2
	 * @return redirect
	 */
	@GetMapping("/like")
	public String like(@RequestParam("id1") int id1, @RequestParam("id2") int id2, ModelMap model) {
		logger.info("----RECIIENDO IDs -> /LIKE");
		perfilService.like(id1, id2);
		model.addAttribute("perfil", perfilService.get(id1));
		model.addAttribute("perfilList", perfilService.getPerfiles(perfilService.get(id1)));
		return "contactos";
	}
	
	/**
	 * Método que envía la información del dislike para guardarla en la base de datos
	 * @param idPerfil
	 * @param idDislike
	 * @return contactos
	 */
	@GetMapping("/dislike")
	public String dislike(@RequestParam("id1") int id1, @RequestParam("id2") int id2, ModelMap model) {
		logger.info("-------PerfilController dislike");
		perfilService.dislike(id1, id2);
		model.addAttribute("perfil", perfilService.get(id1));
		model.addAttribute("perfilList", perfilService.getPerfiles(perfilService.get(id1)));
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
		perfilService.guardarIntereses(idPerfil, genero, edadMin, edadMax);
		logger.info("-------PerfilController guardarIntereses");
		return "perfil";
	}
	
	/**
	 * Método que da de baja a un usuario cuando le proporciona un id
	 * @param idPerfil
	 * @return index
	 */
	@GetMapping("/baja")
	public String bajaPerfil(@RequestParam("idperfil") int idPerfil) {
		perfilService.delete(idPerfil);
		logger.info("--------PerfilController baja");
		return "index";
	}
	
}

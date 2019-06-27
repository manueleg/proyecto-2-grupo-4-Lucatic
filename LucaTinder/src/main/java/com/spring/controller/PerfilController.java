package com.spring.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/* 
* @author grupo4
* @version 1.0 27/06/2019
* Clase con la anotación @Controller. Es un controlador y pertenece a la capa de presentación.
*/

@Controller
public class PerfilController {

	/*@Autowired
	private PerfilServices perfilService;*/
	
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
	
}

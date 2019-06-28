package com.spring.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* 
* @author grupo4
* @version 1.0 27/06/2019
* Clase que será un especialista en proporcionar objetos de tipo Perfil.
*/

public class PerfilMaker {

	/**
	 * Instancia del Logger
	 */
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(PerfilMaker.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	
	public static Perfil damePerfil() {
		return null;
	}
}

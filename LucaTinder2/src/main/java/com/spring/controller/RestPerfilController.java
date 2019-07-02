package com.spring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.services.PerfilService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/contactos"})
public class RestPerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(RestPerfilController.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	
	
}

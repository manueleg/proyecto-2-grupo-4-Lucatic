package com.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spring.controller.PerfilController;
import com.spring.dao.PerfilRepository;
import com.spring.model.Perfil;
import com.spring.model.PerfilMaker;

/**
 * 
 * @author David Nombre de clase: PerfilServices Descripcion: Metodos en
 * clase getters en clase PerfilServicesImpl  Fecha: 27/06/2019
 * @version: v1.0
 *
 */

@Service
@Transactional
public class PerfilServicesImpl implements PerfilServices {

	@Autowired
	private com.spring.repository.PerfilRepository perfilDAO;

	/*
	 * public UserServiceImpl(){
	 * 
	 * }
	 * 
	 * public UserServiceImpl(UserDAO userDAO) { super(); this.userDAO =
	 * userDAO; }
	 */

	
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
	
	@Override
	public List<Perfil> generarPerfiles() {
		logger.log(Level.INFO,"Busca el perfil...");
		List<Perfil>perfiles;
		int cont = 0;
		boolean fin = false;
		do {
			perfiles.add(PerfilMaker.crearPerfil());
			cont++;
			if(cont<=10) {
				fin=true;
			}
		}while(fin);
		return perfiles;
	}

	@Override
	public Perfil get(int id) {
		logger.log(Level.INFO,"Obtiene el perfil...");
		return perfilDAO.findOne(id);
	}

	@Override
	public void update(Perfil user) {
		logger.log(Level.INFO,"Actualiza el perfil...");
		perfilDAO.save(user);
	}
	
	@Override
	public void add(Perfil user) {
		logger.log(Level.INFO,"Guarda el perfil...");
		perfilDAO.save(user);
	}

	@Override
	public void delete(int id) {
		logger.log(Level.INFO,"Borra el perfil...");
		perfilDAO.delete(id);
	}
		

	@Override
	public void like(int id1, int id2) {
		final Logger logger = LogManager.getLogger("Mensaje");
		logger.log(Level.INFO,"Dar Me gusta (like)...");
		perfilDAO.like(id);
	}
	

	@Override
	public void guardarPerfiles() {
		logger.log(Level.INFO,"Cargando perfil...");
		for(Perfil p : generarPerfiles()) {
			perfilDAO.save(p);
		}
		
	}

}

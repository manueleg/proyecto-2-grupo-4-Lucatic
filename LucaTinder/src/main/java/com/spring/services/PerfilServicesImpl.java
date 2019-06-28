package com.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import com.spring.controller.PerfilController;
import com.spring.repository.PerfilRepository;
//import com.spring.model.Intereses;
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

		logger.info("---Busca el perfil");
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
		logger.info("---Obtiene el perfil");
		return perfilDAO.findOne(id);
	}

	@Override
	public void update(Perfil user) {
		logger.info("---Actualizar perfil");
		perfilDAO.save(user);
	}
	
	@Override
	public void add(Perfil user) {

		logger.info("---Guardar perfiles");

		perfilDAO.save(user);
	}

	@Override
	public void delete(int id) {

		logger.info("---Borrar perfiles");
		perfilDAO.deleteById(id);

	}
		

	@Override
	public void like(int id1, int id2) {
		
		logger.info("---Dar me gusta");
		perfilDAO.like(id1, id2);

	}
	
	@Override
	public void guardarPerfiles() {
		logger.info("---Cargando perfiles");
		for(Perfil p : generarPerfiles()) {
			perfilDAO.save(p);
		}
	}

	@Override
	public List<Perfil> getPerfiles() {
		// TODO Auto-generated method stub
		return perfilDAO.findAll();}

	public void dislike(int id1, int id2) {
		logger.info("---Dar no me gusta");
		perfilDAO.like(id1, id2);

	}

	@Override
	public void guardarIntereses(int idPerfil, String genero, int edadMin, int edadMax) {
		logger.info("----Guardar intereses");
		perfilDAO.insertarIntereses(idPerfil, genero, edadMin, edadMax);
	}
	
	
	

}

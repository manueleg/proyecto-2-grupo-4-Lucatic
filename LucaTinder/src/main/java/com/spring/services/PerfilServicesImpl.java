package com.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.spring.dao.PerfilRepository;
import com.spring.model.Perfil;

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
	private PerfilRepository perfilDAO;

	/*
	 * public UserServiceImpl(){
	 * 
	 * }
	 * 
	 * public UserServiceImpl(UserDAO userDAO) { super(); this.userDAO =
	 * userDAO; }
	 */

	@Override
	public List<Perfil> list() {
		final Logger logger = LogManager.getLogger("Mensaje");
		logger.log(Level.INFO,"Busca el perfil...");

		return perfilDAO.findAll();
	}

	@Override
	public Perfil get(int id) {
		final Logger logger = LogManager.getLogger("Mensaje");
		logger.log(Level.INFO,"Obtiene el perfil...");
		return perfilDAO.findOne(id);
	}

	@Override
	public void update(Perfil user) {
		final Logger logger = LogManager.getLogger("Mensaje");
		logger.log(Level.INFO,"Actualiza el perfil...");
		perfilDAO.save(user);
	}

	@Override
	public void add(Perfil user) {
		final Logger logger = LogManager.getLogger("Mensaje");
		logger.log(Level.INFO,"Guarda el perfil...");
		perfilDAO.save(user);
	}

	@Override
	public void delete(int id) {
		final Logger logger = LogManager.getLogger("Mensaje");
		logger.log(Level.INFO,"Borra el perfil...");
		perfilDAO.delete(id);
	}

}

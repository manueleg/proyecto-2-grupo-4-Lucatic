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
		logger.info("---Generar perfil");

		return perfilDAO.findAll();
	}

	@Override
	public Perfil get(int id) {
		logger.info("---Encontrar perfil");
		return perfilDAO.findOne(id);
	}

	@Override
	public void update(Perfil user) {
		logger.info("---Actualizar perfil");
		perfilDAO.save(user);
	}

	@Override
	public void add(Perfil user) {
		logger.info("---Guardar perfil");
		perfilDAO.save(user);
	}

	@Override
	public void delete(int id) {
		logger.info("---Borrar perfil");
		perfilDAO.delete(id);
	}
		

	@Override
	public void like(int id1, int id2) {
		logger.info("---Dar me gusta");
		perfilDAO.like(id);
	}
	

	@Override
	public void dislike(int id1, int id2) {
		logger.info("---Dar no me gusta");
		perfilDAO.like(id);
	}

}

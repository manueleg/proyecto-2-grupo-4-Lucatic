package com.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Perfil;
import com.spring.model.PerfilMaker;
import com.spring.repository.PerfilRepository;

/**
 * 
 * @author David Nombre de clase: PerfilServices Descripcion: Metodos en
 * clase getters en clase PerfilServicesImpl  Fecha: 27/06/2019
 * @version: v1.0
 *
 */

@Service
@Transactional
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository perfilDAO;

	/**
	 * Instancia del Logger
	 */
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(PerfilServiceImpl.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	
	@Override
	public List<Perfil> generarPerfiles() {
		// TODO Auto-generated method stub
		logger.info("---Busca el perfil");
		List<Perfil>perfiles = new ArrayList<>();
		int cont = 0;
		boolean fin = false;
		do {
			perfiles.add(PerfilMaker.damePerfil());
			cont++;
			if(cont<=10) {
				fin=true;
			}
		}while(fin);
		return perfiles;
	}

	@Override
	public Perfil get(int id) {
		// TODO Auto-generated method stub
		logger.info("---Obtiene el perfil");
		System.out.println("getttttt");
		System.out.println(perfilDAO.findById(id));
		Optional<Perfil> perfilOptional = perfilDAO.findById(id);
		System.out.println("get2222222");
		if (perfilOptional.isPresent()){
			System.out.println("get333333");
			Perfil p = perfilOptional.get();
			System.out.println(p);
			return p;
		}
		else{
		   return null;
		}
	}

	@Override
	public List<Perfil> getPerfiles(Perfil perfil) {
		List<Perfil> perfilesList=new ArrayList<Perfil>();
		List<Perfil> perfilesLike=new ArrayList<Perfil>();
		List<Perfil> perfilesDislike=new ArrayList<Perfil>();
		System.out.println(perfilDAO.getLikes(perfil).toString());
		perfilesList=perfilDAO.getPerfiles();
		perfilesLike=perfilDAO.getLikes(perfil);
		perfilesDislike=perfilDAO.getDislikes(perfil);
		perfilesList.remove(perfil);
		for(Perfil p:perfilesLike) {
			perfilesList.remove(p);
		}
		for(Perfil p:perfilesDislike) {
			perfilesList.remove(p);
		}
		//System.out.println(perfilesList.toString());
		return perfilesList;
	}

	@Override
	public void guardarPerfiles() {
		// TODO Auto-generated method stub
		logger.info("---Cargando perfiles");
		for(Perfil p : generarPerfiles()) {
			perfilDAO.save(p);
		}
	}

	@Override
	public void guardarIntereses(int idPerfil, String genero, int edadMin, int edadMax) {
		// TODO Auto-generated method stub
		logger.info("----Guardar intereses");
		perfilDAO.insertarIntereses(idPerfil, genero, edadMin, edadMax);
	}

	@Override
	public void update(Perfil user) {
		// TODO Auto-generated method stub
		logger.info("---Actualizar perfil");
		perfilDAO.save(user);
	}

	@Override
	public void add(Perfil user) {
		// TODO Auto-generated method stub
		logger.info("---Guardar perfiles");
		perfilDAO.save(user);
	}

	@Override
	public void delete(int id) {
		logger.info("---Borrar perfil");
		perfilDAO.deleteById(id);
	}

	@Override
	public void like(int id1, int id2) {
		// TODO Auto-generated method stub
		logger.info("---Dar me gusta");
		perfilDAO.like(id1, id2);
	}

	@Override
	public void dislike(int id1, int id2) {
		// TODO Auto-generated method stub
		logger.info("---Dar no me gusta");
		perfilDAO.dislike(id1, id2);
	}
	
	

	
	
}

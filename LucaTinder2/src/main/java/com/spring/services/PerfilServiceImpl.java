package com.spring.services;

import java.util.ArrayList;
import java.util.Iterator;
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
 * @author David Nombre de clase: PerfilServices Descripcion: Metodos en clase
 *         getters en clase PerfilServicesImpl Fecha: 27/06/2019
 * @version: v1.0
 *
 */

@Service
@Transactional
public class PerfilServiceImpl implements PerfilService {

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
		List<Perfil> perfiles = new ArrayList<>();
		int cont = 0;
		boolean fin = false;
		do {
			perfiles.add(PerfilMaker.damePerfil());
			cont++;
			if (cont <= 10) {
				fin = true;
			}
		} while (fin);
		return perfiles;
	}

	@Override
	public Perfil get(int id) {
		// TODO Auto-generated method stub
		logger.info("---Obtiene el perfil");
		Optional<Perfil> perfilOptional = perfilDAO.findById(id);
		if (perfilOptional.isPresent()) {
			Perfil p = perfilOptional.get();
			return p;
		} else {
			return null;
		}
	}

	@Override
	public List<Perfil> getPerfiles(Perfil perfil) {
		List<Perfil> perfilesList = perfilDAO.getPerfiles();
		perfilesList.remove(perfil);
		Iterator<Perfil> it = perfilDAO.getLikes(perfil).iterator();
		while (it.hasNext()) {
			perfilesList.remove(it.next());
		}
		Iterator<Perfil> it2 = perfilDAO.getDislikes(perfil).iterator();
		while (it2.hasNext()) {
			perfilesList.remove(it2.next());
		}
		return perfilesList;
	}
	
	@Override
	public List<Perfil> getinsertarIntereses(Perfil perfil) {
		logger.info("---Obtiene los intereses");
		List<Perfil> perfilesIntereses = perfilDAO.getinsertarIntereses();
				
		return perfilesIntereses;
	}
	
	@Override
	public List<Perfil> getPerfilesMatch(Perfil perfil) {
		logger.info("---Obtiene los intereses");
		List<Perfil> perfilesMatch = perfilDAO.getPerfilesMatch(0);
				
		return perfilesMatch;
	}

	
	

	@Override
	public void guardarPerfiles() {
		// TODO Auto-generated method stub
		logger.info("---Cargando perfiles");
		for (Perfil p : generarPerfiles()) {
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
		for(Perfil p:perfilDAO.getLikes(get(id2))) {
			if(p.equals(get(id1))) {
				perfilDAO.match(id1, id2);
			}
		}
	}

	@Override
	public void dislike(int id1, int id2) {
		// TODO Auto-generated method stub
		logger.info("---Dar no me gusta");
		perfilDAO.dislike(id1, id2);
	}


}

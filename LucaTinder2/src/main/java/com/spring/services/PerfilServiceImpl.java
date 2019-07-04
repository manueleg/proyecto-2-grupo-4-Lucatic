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
		do {
			perfiles.add(PerfilMaker.damePerfil());
			cont++;
		} while (cont<10);
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
		if(perfilDAO.findAll().size()<10) {
			guardarPerfiles();
		}
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
	
	/**
	 * Método que devuelve una lista de perfiles filtrada por los intereses del perfil introducido
	 * @param Perfil, ModelMap
	 * @return contactos
	 */
	@Override
	public List<Perfil> getPerfilesIntereses(Perfil perfil) {
		logger.info("---Obtiene los intereses");
		List<Perfil> perfilesIntereses = perfilDAO.getPerfilesIntereses(perfil);
				
		return perfilesIntereses;
	}
	
	@Override
	public List<Perfil> getPerfilesMatch(Perfil perfil) {
		logger.info("---Obtiene los intereses");
		List<Perfil> perfilesMatch = perfilDAO.getPerfilesMatch(perfil);
				
		return perfilesMatch;
	}

	
	

	@Override
	public void guardarPerfiles() {
		// TODO Auto-generated method stub
		logger.info("---Cargando perfiles");
		Iterator<Perfil> it = generarPerfiles().iterator();
		while (it.hasNext()) {
			perfilDAO.save(it.next());
		}
	}

	@Override
	public void guardarIntereses(int idPerfil, String genero, int edadMin, int edadMax) {
		// TODO Auto-generated method stub
		logger.info("----Guardar intereses");
		perfilDAO.insertarIntereses(idPerfil, genero, edadMin, edadMax);
	}

	@Override
	public void update(Perfil perfil) {
		// TODO Auto-generated method stub
		logger.info("---Actualizar perfil");
		//perfilDAO.deleteById(perfil.getIdusuario());
		perfilDAO.update(perfil);
	}

	@Override
	public void add(Perfil perfil) {
		// TODO Auto-generated method stub
		logger.info("---Guardar perfiles");
		perfilDAO.save(perfil);
	}

	@Override
	public void delete(int id) {
		logger.info("---Borrar perfil");
		perfilDAO.deleteById(id);
	}

	@Override
	public  void like(int id1, int id2) {
		// TODO Auto-generated method stub
		logger.info("---Dar me gusta");
		// Devuelve un iterador con los perfiles a los que el usuario id2 ha dado like
		Iterator<Perfil> it=perfilDAO.getLikes(get(id2)).iterator();
		perfilDAO.like(id1, id2);
		while (it.hasNext()) {
			if(it.next().equals(get(id1))) {
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

package com.spring.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.controller.PerfilController;
import com.spring.model.Perfil;

@Repository
@Transactional(readOnly = true)
public class PerfilRepositoryImpl implements PerfilRepositoryCustom{
	
	@PersistenceContext 
	EntityManager entityManager;
	
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(PerfilController.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	
	@Override
	public List<Perfil> getPerfiles() {
		List<Perfil> perfilesList=new ArrayList<Perfil>();
		Query query = entityManager.createNativeQuery("SELECT * FROM lucatinder.usuarios", Perfil.class);
		for(Object p:query.getResultList()) {
			perfilesList.add((Perfil)p);
		}
		return perfilesList;
	}

	/**
	 * Método like de tipo void que recibe dos parámetros id de tipo int y los guardará en la tabla contactos
	 * de la base de datos.
	 * @param int id1, int id2
	 */
	@Override
	public void like(int id1, int id2) {
		// TODO Auto-generated method stub
		logger.info("--- En método like de la clase PerfilRpositoryImpl");
		entityManager.createNativeQuery("INSERT INTO lucatinder.contactos (idcontacto, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, id1)
	      .setParameter(3, id2)
	      .executeUpdate();
	}
	
	/**
	 * Método match de tipo void que recibe dos parámetros id de tipo int y los guardará en la tabla match
	 * de la base de datos.
	 * @param int id1, int id2
	 */
	@Override
	public void match(int id1, int id2) {
		logger.info("--- En método match de la clase PerfilRpositoryImpl");
		entityManager.createNativeQuery("INSERT INTO lucatinder.matches (idmatch, idusuario, idusuario2) VALUES (?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, id1)
	      .setParameter(3, id2)
	      .executeUpdate();
	}
	
	/**
	 * Método de recupera los likes marcados por un perfil
	 * @param Perfil
	 * @return List<Perfil>
	 */
	@Override
	public List<Perfil> getLikes(Perfil perfil) {
		logger.info("-------PerfilRepositoryImp getLikes");
		List<Perfil> perfilesLike=new ArrayList<Perfil>();
		Query query=entityManager.createNativeQuery("SELECT * FROM lucatinder.usuarios us, (SELECT fk_idusuario2 FROM lucatinder.contactos WHERE fk_idusuario="+perfil.getIdusuario()+") likes WHERE idusuario=fk_idusuario2", Perfil.class);
		for(Object p:query.getResultList()) {
			perfilesLike.add((Perfil)p);
		}
		return perfilesLike;
	}
	
	/**
	 * Método de recupera los dislikes marcados por un perfil
	 * @param Perfil
	 * @return List<Perfil>
	 */
	@Override
	public List<Perfil> getDislikes(Perfil perfil) {
		logger.info("-------PerfilRepositoryImp getDislikes");
		List<Perfil> perfilesDislike=new ArrayList<Perfil>();
		Query query=entityManager.createNativeQuery("SELECT * FROM lucatinder.usuarios us, (SELECT fk_idusuario2 FROM lucatinder.descartes WHERE fk_idusuario="+perfil.getIdusuario()+") likes WHERE idusuario=fk_idusuario2", Perfil.class);
		for(Object p:query.getResultList()) {
			perfilesDislike.add((Perfil)p);
		}
		return perfilesDislike;
	}
	

	/**
	 * Método dislike de tipo void que recibe dos parámetros id de tipo int y los guardará en la tabla descartes
	 * de la base de datos.
	 * @param int id1, int id2
	 */
	@Override
	public void dislike(int id1, int id2) {
		// TODO Auto-generated method stub

		logger.info("--- En método dislike de la clase PerfilRpositoryImpl");
		entityManager.createNativeQuery("INSERT INTO lucatinder.descartes (iddescarte, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, id1)
	      .setParameter(3, id2)
	      .executeUpdate();
	}
	
	@Override
	public void insertarIntereses(int idPerfil, String genero, int edadMin, int edadMax) {
		logger.info("--- En método insertarIntereses de la clase PerfilRepositoryImpl");
		entityManager.createNativeQuery("INSERT INTO lucatinder.intereses (idinteres, edadmax, edadmin, idgenero) VALUES (?,?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, genero)
	      .setParameter(3, edadMin)
	      .setParameter(3, edadMax)
	      .executeUpdate();
	}
	
	
	/**
	 * Método que devuelve una lista de perfiles filtrada por los intereses del perfil introducido
	 * @param Perfil
	 * @return List<Perfil>
	 */
	@Override
	public List<Perfil> getPerfilesIntereses(Perfil perfil) {
		List<Perfil> perfilesIntereses = new ArrayList<Perfil>();
		Query query=entityManager.createNativeQuery("SELECT \n" + 
				"    u.idusuario,\n" + 
				"    u.nombre,\n" + 
				"    u.genero,\n" + 
				"    u.fecha_nac,\n" + 
				"    u.poblacion,\n" + 
				"    u.idintereses,\n" + 
				"    u.descripcion\n" + 
				"FROM\n" + 
				"    usuarios AS u,\n" + 
				"    (SELECT \n" + 
				"        i.edadmin, i.edadmax, g.nombre\n" + 
				"    FROM\n" + 
				"        intereses AS i\n" + 
				"    LEFT JOIN generos AS g ON i.idgenero = g.idgenero UNION SELECT \n" + 
				"        i.edadmin, i.edadmax, g.nombre\n" + 
				"    FROM\n" + 
				"        intereses AS i\n" + 
				"    RIGHT JOIN generos AS g ON i.idgenero = g.idgenero\n" + 
				"    WHERE\n" + 
				"        i.idinteres=1) AS s\n" + 
				"WHERE\n" + 
				"    (((YEAR(CURDATE()) - YEAR(u.fecha_nac)) BETWEEN s.edadmin AND s.edadmax))\n" + 
				"        AND (CASE s.nombre\n" + 
				"        WHEN 'a' THEN u.genero = ('h' OR 'm')\n" + 
				"        ELSE u.genero = s.nombre\n" + 
				"    END);", Perfil.class);
		for(Object m : query.getResultList()) {
			perfilesIntereses.add((Perfil) m);
		}
		return perfilesIntereses;
	}
	

	@Override
	public List<Perfil> getPerfilesMatch(Perfil perfil) {
		logger.info("-------PerfilRepositoryImp getPerfilesMatch");
		List<Perfil>perfilesMatch=new ArrayList<Perfil>();
		Query query=entityManager.createNativeQuery("SELECT * FROM lucatinder.matches us, (SELECT idusuario2 FROM lucatinder.matches WHERE idusuario="+perfil.getIdusuario()+") likes WHERE idusuario=idusuario2", Perfil.class);
		for(Object m : query.getResultList()) {
			perfilesMatch.add((Perfil) m);
		}
		return perfilesMatch;
		
	}


}

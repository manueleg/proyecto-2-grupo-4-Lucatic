package com.spring.repository;

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
public class PerfilRepositoryImp implements PerfilRepositoryCustom{
	
	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(PerfilController.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}
	
	@PersistenceContext 
	EntityManager em;
	
	@Override
	public List<Perfil> getPerfiles() {
		Query query = em.createNativeQuery("SELECT * FROM lucatinder.usuarios.nombre " +
                "WHERE nombre LIKE ?", Perfil.class);
		return query.getResultList();
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
		em.createNativeQuery("INSERT INTO lucatinder.contactos (idcontacto, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, id1)
	      .setParameter(3, id2)
	      .executeUpdate();
	}

	/**
	 * Método dislike de tipo void que recibe dos parámetros id de tipo int y los guardará en la tabla descartes
	 * de la base de datos.
	 * @param int id1, int id2
	 */
	@Override
	public void dislike(int id1, int id2) {
		logger.info("--- En método dislike de la clase PerfilRpositoryImpl");
		em.createNativeQuery("INSERT INTO lucatinder.descartes (iddescarte, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, id1)
	      .setParameter(3, id2)
	      .executeUpdate();
	}

	@Override
	public void guardar(Perfil perfil) {
		// TODO Auto-generated method stub
		logger.info("--- En método guardar de la clase PerfilRpositoryImpl");
		/*String query = "insert into usuarios values(null,?)";

		em.createNativeQuery(query)
		   .setParameter(1, "Tom")
		   .executeUpdate();*/

		em.createNativeQuery("INSERT INTO lucatinder.usuarios (idusuario, nombre, genero, edad, poblacion, idintereses, descripcion) VALUES (null,?,?,?,?,?,?)")
		  .setParameter(1, null)
	      .setParameter(2, perfil.getNombre())
	      .setParameter(3, perfil.getGenero())
	      .setParameter(4, perfil.getEdad())
	      .setParameter(5, perfil.getPoblacion())
	      .setParameter(6, perfil.getIdintereses())
	      .setParameter(7, perfil.getDescripcion())
	      .executeUpdate();
	}
	
	@Override
	public void intereses(int idPerfil, String genero, int edadMin, int edadMax) {
		logger.info("--- En método intereses de la clase PerfilRepositoryImpl");
		em.createNativeQuery("INSERT INTO lucatinder.intereses (idinteres, edadmax, edadmin, idgenero) VALUES (?,?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, genero)
	      .setParameter(3, edadMin)
	      .setParameter(3, edadMax)
	      .executeUpdate();
	}
	
}

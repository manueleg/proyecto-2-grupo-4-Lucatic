package com.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Perfil;

@Repository
@Transactional(readOnly = true)
public class PerfilRepositoryImp implements PerfilRepositoryCustom{

	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	public List<Perfil> getPerfiles() {
		Query query = entityManager.createNativeQuery("SELECT * FROM lucatinder.usuarios.nombre " +
                "WHERE nombre LIKE ?", Perfil.class);
		return query.getResultList();
	}

	/**
	 * Método like de tipo void que recoge dos parámetros id de tipo int y los guardará en la tabla contactos
	 * de la base de datos.
	 * @param int id1, int id2
	 */
	@Override
	public void like(int id1, int id2) {
		// TODO Auto-generated method stub
		entityManager.createNativeQuery("INSERT INTO lucatinder.contactos (idcontacto, fk_idusuario, fk_idusuario2) VALUES (?,?,?)")
	      .setParameter(1, null)
	      .setParameter(2, id1)
	      .setParameter(3, id2)
	      .executeUpdate();
	}
	
}

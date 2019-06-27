package com.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.spring.model.Perfil;

public class PerfilRepositoryImp implements PerfilRepositoryCustom{

	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	public List<Perfil> getPerfiles() {
		Query query = entityManager.createNativeQuery("SELECT * FROM lucatinder.usuarios.nombre " +
                "WHERE nombre LIKE ?", Perfil.class);
		return query.getResultList();
	}

}

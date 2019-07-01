package com.spring.repository;

import java.util.List;

import com.spring.model.Perfil;


public interface PerfilRepositoryCustom {

	List<Perfil> getPerfiles();
	void like(int id1, int id2);
	void dislike(int id1, int id2);
	void insertarIntereses(int idPerfil, String genero, int edadMin, int edadMax);
}

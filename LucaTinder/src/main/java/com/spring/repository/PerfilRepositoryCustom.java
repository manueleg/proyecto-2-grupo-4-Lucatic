package com.spring.repository;

import java.util.List;
import com.spring.model.Perfil;

public interface PerfilRepositoryCustom {
	
	public List<Perfil> getPerfiles();
	public void like(int id1, int id2);
	public void dislike(int id1, int id2);
	public void insertarIntereses(int idPerfil, String genero, int edadMin, int edadMax);
	public void guardar(Perfil perfil);
}

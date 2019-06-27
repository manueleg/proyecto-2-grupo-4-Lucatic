package com.spring.services;

import java.util.List;

import com.spring.model.Perfil;

/**
 * 
 * @author David Nombre de clase: PerfilServices Descripcion: Metodos 
 * para añadir, actualizar y borrar perfil Fecha: 27/06/2019
 * @version: v1.0
 *
 */


public interface PerfilServices {

	public List<Perfil> list();
	
	public Perfil get(int id);
	
	public void update(Perfil user);
	public void add(Perfil user);
	
	public void delete(int id);
	
	public void like(int id1, int id2);
	
	public void dislike(int id1, int id2);
}

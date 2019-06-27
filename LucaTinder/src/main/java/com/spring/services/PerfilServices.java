package com.spring.services;

import java.util.List;

import com.spring.model.User;

public interface PerfilServices {

	public List<Perfil> list();
	
	public Perfil get(int id);
	
	public void update(Perfil user);
	public void add(Perfil user);
	
	public void delete(int id);
}

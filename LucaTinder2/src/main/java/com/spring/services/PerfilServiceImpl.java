package com.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Perfil;
import com.spring.repository.PerfilRepository;

@Service
@Transactional
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository perfilDAO;

	@Override
	public List<Perfil> generarPerfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil get(int idnombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Perfil> getPerfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarPerfiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarIntereses(int idPerfil, String genero, int edadMin, int edadMax) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Perfil user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Perfil user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void like(int id1, int id2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dislike(int id1, int id2) {
		// TODO Auto-generated method stub
		
	}

	
	
}

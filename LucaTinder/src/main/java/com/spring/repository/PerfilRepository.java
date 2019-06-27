package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>,PerfilRepositoryCustom{
	
	

}

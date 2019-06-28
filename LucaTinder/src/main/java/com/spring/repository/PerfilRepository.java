package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>,PerfilRepositoryCustom{
}

package com.telcel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telcel.entities.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

	Usuario findByNombre(String nombre);
}

package com.appweb.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appweb.entity.Usuario;

@Repository("usuariosrepository")
public interface UsuariosRepository extends JpaRepository<Usuario, Serializable>{
		
		//este metodo no está incluido en Repository por eso lo creamos
	//para buscar en la bbdd por id
		public abstract Usuario findById(int id);
}

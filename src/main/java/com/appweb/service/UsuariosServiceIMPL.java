package com.appweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.appweb.entity.Usuario;
import com.appweb.repository.UsuariosRepository;

@Service("usuariosservice")
public class UsuariosServiceIMPL implements UsuarioService {

	//Se debe inyectar el repositorio en la implementacion del servicio
	@Autowired
	@Qualifier("usuariosrepository")
	private UsuariosRepository ur;
	
	@Override //Este metodo agrega los usuarios a la BBDD, pero no se releja en la view de la lista, eso se hace en otro lado
	public Usuario addUsuarios(Usuario usuarios) {
		
		//aqui está la sentencia sql que nos brinda JPARepository para añadir los usuarios a la BBDD
		return ur.save(usuarios); //para añadir los usuarios a la BBDD, pero no sabe distinguir si el usuario es nuevo o hay que actualizar
	}

	@Override
	public List<Usuario> ListAllUsuarios() {

		List<Usuario> users_list = new ArrayList<>();
		
		//aqui está la sentencia sql que nos brinda JPARepository
		users_list = ur.findAll(); //con la variable ur del repository y el metodo findAll, traemos todos los elementos de la tabla que está en la BBDD
		return users_list;
		//Ahore de deben modificar las view para ver la lista, desde la view user
	}

	@Override
	public Usuario findUsuariosById(int id) {
	
		return ur.findById(id);//metodo del repository para buscaar por ID
	}

	@Override
	public void removeUsuarios(int id) {
		
		Usuario us = findUsuariosById(id);
		
		if(us!=null) {
			ur.delete(us);
		}
	}

}

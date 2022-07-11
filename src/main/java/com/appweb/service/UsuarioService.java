package com.appweb.service;

import java.util.List;

import com.appweb.entity.Usuario;

public interface UsuarioService {
 
		public abstract Usuario addUsuarios(Usuario usuarios);//metodo para añadir contactos
		public abstract List<Usuario> ListAllUsuarios();
		
		public abstract Usuario findUsuariosById(int id);//para buscar el usuario a eliminar
		public abstract void removeUsuarios(int id); //elimina el usuaio encontrado
}

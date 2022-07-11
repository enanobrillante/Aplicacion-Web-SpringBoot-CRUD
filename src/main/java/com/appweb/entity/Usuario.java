package com.appweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="usuario")//es el nombre de la tabla en la bbdd
public class Usuario {

		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY) //para que hibernate genere el id
		@Column(name="id")
		private int id;
		@Column(name="nombre") //Esto es mapeo ORM, el campo nombre de la BBDD se corresponderá con este atributo nombre
		private String nombre;
		@Column(name="apellido")
		private String apellido;
		@Column(name="telefono")
		private String telefono;
		@Column(name="correo")
		private String correo;
		
		public Usuario() {}
		
		public Usuario(int id, String nombre, String apellido, String telefono, String correo) {
			super();
			this.id =id;
			this.nombre = nombre;
			this.apellido = apellido;
			this.telefono = telefono;
			this.correo = correo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}
		
		
}

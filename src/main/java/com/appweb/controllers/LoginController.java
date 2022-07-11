package com.appweb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appweb.model.Credenciales;

@Controller

public class LoginController {

	//Metodo para redirigirnos al login, de tal manera que si queremos agregar, o eliminar un usuario tendremos que estar logueados
	@GetMapping("/")
	public String redirectLogin() {
			return "redirect:/login";
	}
	@GetMapping("/login")
	public String login(Model model,@RequestParam(name="error",required= false)String error,
									@RequestParam(name="logout",required= false)String logout){
		
		model.addAttribute("error",error);//Añadimos el atributo al modelo con el valor logout
		model.addAttribute("logout",logout);
		model.addAttribute("credenciales",new Credenciales());//para que el prgrama se entere de que estamos trabajano con la clase credenciales 
		return "login"; 
	}
	@PostMapping("/check") //este metodo retorna un listado de usuarios, en una plantilla donde se agregaran los usuarios luego
	public String check(@ModelAttribute(name="credenciales")Credenciales credenciales) { //el @ModelAttribute es para poder trabajar con la clase credenciales
		//Lógica para validar al usuario que quiere ingresar
		if(credenciales.getNombre().equals("paco") && credenciales.getPass().equals("123")) {
			return "redirect:/usuarios/listadousers"; //en este formulario de users se rescarta la informacion que viaja en credenciales
		}else { // listadousers es la view que está en UsuariosController
			return "redirect:/login?error"; //para que genere un mensaje cuando las credenciales sean incorrectas
		}
		
	}
}

package com.appweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appweb.entity.Usuario;
import com.appweb.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")//Path a nivel de clase
public class UsuariosController {
	
	@Autowired
	@Qualifier("usuariosservice")
	private UsuarioService us;
	
	
	
	//metodo que solo devuelve la vista para agregar usuarios
		@GetMapping("/usersform")//Path para que entre a nivel metodo
		public String usersForm(Model model,@RequestParam(name="id", required=true) int id) {
			
			Usuario user = new Usuario();
			if(id!=0) {
				user = us.findUsuariosById(id);
				
			}
			
			model.addAttribute("usuarios_model",user);//para que sepa que estamos trabajando con la clase usuarios, y poder agregar o eliminar
			return "usersForm";//nombre del template
			
			
			
			
		}
		
		@PostMapping("/addusuarios")//REcoge los datos del usuario via post
		public String addUsuarios(@ModelAttribute(name="usuarios_model")Usuario usuario_param) {
			
			us.addUsuarios(usuario_param);
			return "redirect:/usuarios/listadousers";//retorna el listado de usuarios, con el último agregado
		}
		
		//Metodo que nos devuelve a la vista, el listado de usuarios rescatados desde BBDD, por medio de UsusarioServiceIMPL
		@GetMapping("/listadousers")
		public ModelAndView ListadoUsuarios() {
			
			ModelAndView mav = new ModelAndView("users"); //Users es la vista
			mav.addObject("listadoDeUsuarios", us.ListAllUsuarios()); //Guarda en listadoDeUsuarios lo que trae de us.ListAllUsuarios que está en la clase UsuariosServiceIMPL
			return mav;
		}
		
		
		@GetMapping("/removeusuarios")
		public ModelAndView removeUsuarios(@RequestParam(name="id", required=true) int id) {
			
			us.removeUsuarios(id);
			return ListadoUsuarios();
		}
}

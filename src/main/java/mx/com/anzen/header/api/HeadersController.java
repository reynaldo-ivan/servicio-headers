package mx.com.anzen.header.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.anzen.header.models.UserBeans;

@Controller
@RequestMapping("/header")
public class HeadersController {
 
	@RequestMapping("/login")
	public String welcome(Map<String, Object> model) {
		Operaciones operaciones=new Operaciones();
		UserBeans beans= operaciones.consultaJSON();
		System.out.println("pwd  "+beans.getPwd());
		model.put("Usuario", beans.getPwd());
		model.put("Contrasenia", beans.getUser());
		return "welcome";
	}
}

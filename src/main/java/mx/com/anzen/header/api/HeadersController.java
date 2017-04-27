package mx.com.anzen.header.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.com.anzen.header.models.UserBeans;
import mx.com.anzen.header.service.IHeaderService; 

@Controller
@RequestMapping("/header")
public class HeadersController {
	
	@Autowired
	private IHeaderService servicio; 
 
	@RequestMapping("/login")
	public String welcome(Map<String, Object> model) { 
		UserBeans beans= servicio.consultaJSON();
		System.out.println("pwd  "+beans.getPwd());
		model.put("Usuario", beans.getPwd());
		model.put("Contrasenia", beans.getUser());
		return "welcome";
	}
}

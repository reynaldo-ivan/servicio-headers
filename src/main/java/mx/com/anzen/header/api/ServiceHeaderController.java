package mx.com.anzen.header.api;

import java.net.UnknownHostException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.anzen.header.models.UserBeans;
  
@RestController
public class ServiceHeaderController {
	 
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/headers")
    public String test(@RequestHeader(value="user") String  user,
    		@RequestHeader(value="pwd") String  pwd) throws UnknownHostException{ 
		JSONObject jsonObject=new JSONObject();
		 
		
		UserBeans beans=new UserBeans();
		UserBeans bean1=new UserBeans();
		bean1.setPwd(pwd);
		bean1.setUser(user);
		beans.setBeans(bean1);
		 
		jsonObject.put("user", user);
		jsonObject.put("pwd", pwd);
		System.out.println("user "+user);
		 System.out.println("pwd "+pwd);
        return "OK";
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consultHeader")
    public JSONObject consulta() throws UnknownHostException{ 
		JSONObject jsonObject=new JSONObject();
		
		UserBeans beans=new UserBeans(); 
		
		jsonObject.put("user", beans.getBeans().getUser());
		jsonObject.put("pwd", beans.getBeans().getPwd());
		
        return jsonObject;
    }
	 
}

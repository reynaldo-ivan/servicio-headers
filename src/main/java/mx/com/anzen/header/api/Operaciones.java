package mx.com.anzen.header.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import mx.com.anzen.header.models.ConsultaBean;
import mx.com.anzen.header.models.UserBeans; 
 
@Repository
@Service
public class Operaciones {
	 
	@Autowired
	private ConsultaBean consulta;
	
public UserBeans consultaJSON() {
		   
		Object object=null;
		JSONArray arrayObj=null;
		String output=null;  
		String json="";
		JSONParser jsonParser=null;
		UserBeans userBeans=null;
		
		 try {
			 	System.out.println("url service  "+consulta.getRestUrl());
				URL url = new URL(consulta.getRestUrl());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
 
				while ((output = br.readLine()) != null) { 
					json=json+output; 
				}     
				jsonParser=new JSONParser();
				 
				try {
					userBeans=new UserBeans();
					object=jsonParser.parse(json.toString()); 
					JSONObject obj2 = (JSONObject)object;  
					userBeans.setUser(obj2.get("user").toString());
					userBeans.setPwd(obj2.get("pwd").toString()); 
					 
				} catch (ParseException e) { 
					System.out.println("Error: "+e.getMessage());
				}
				conn.disconnect(); 
			  } catch (MalformedURLException e) { 
				System.out.println("Error: "+e.getMessage()); 
			  } catch (IOException e) { 
				System.out.println("Error: "+e.getMessage());

			  }
 
		return userBeans;
	}
}

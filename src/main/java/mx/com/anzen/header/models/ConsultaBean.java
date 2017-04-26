package mx.com.anzen.header.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Clase que nos trae las variables de el archivo properties
 *  
 * @author anzen
 *
 */

@ComponentScan
@PropertySource("classpath:/application.properties") 
public class ConsultaBean {
	

	public ConsultaBean() {
		// TODO Auto-generated constructor stub
	}
	 
	/**
	 * Atributo usado para obtener la url del servicio
	 * que nos va a traer las credenciales
	 */
	@Value("${service.url}")
	private String restUrl;

	public String getRestUrl() {
		return restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}
	 
}

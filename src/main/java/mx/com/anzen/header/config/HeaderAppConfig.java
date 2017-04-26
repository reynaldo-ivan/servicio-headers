package mx.com.anzen.header.config;
 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import mx.com.anzen.header.models.ConsultaBean;
 
@ComponentScan("mx.com.anzen.header")
@Configuration
public class HeaderAppConfig {
	
	//Minio
	
	@Bean
	public ConsultaBean conexionConsulta(){
		return new ConsultaBean();
	}
 
	 
	
}

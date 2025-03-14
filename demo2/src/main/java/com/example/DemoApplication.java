package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ioc.Rango;
import com.example.ioc.Repositorio;
import com.example.ioc.Servicio;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	// II
	@Autowired  //(required=false)	
	Servicio srv;
	
	//@Autowired  
	//@Qualifier("verdadero")	
	//Repositorio repo1;
	
	//@Autowired  	
	//@Qualifier("falso")
	//Repositorio repo2;
	
	//@Autowired  		
	//Repositorio repo;
		
	@Autowired  	@Qualifier("repo1")   
	Repositorio repo1;
	
	@Autowired  	@Qualifier("repo2")
	Repositorio repo2;
	
	@Value("${mi.valor:valor por defecto}")
	String valor;
	
	@Autowired
	Rango rango;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Applicación arrancada");
		// I
		//Servicio srv = new ServicioImpl(new RepositorioImpl(new Configuracion()));		
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		//srv.guardar();
		//repo.guardar();
		repo1.guardar();
		repo2.guardar();
				
		System.err.println("Valor = "+valor);		
		System.err.println("Rango = "+rango);
	}
	
	@Bean
	public CommandLineRunner demo() {
		return (args)->{
			System.err.println("Applicación arrancada desde Bean");
		};
	}

}

package br.com.alessanderleite.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alessanderleite.app.dao.ClientRepository;

@SpringBootApplication
public class PagingAndSortingApplication {

	@Autowired
	ClientRepository clientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PagingAndSortingApplication.class, args);
	}

}

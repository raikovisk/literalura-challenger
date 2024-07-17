package com.flavio.liter_alura;

import com.flavio.liter_alura.principal.MainClass;
import com.flavio.liter_alura.repository.LivroRepository;
import com.flavio.liter_alura.view.MenuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MenuView menu = new MenuView();
		MainClass mainClass =  new MainClass(repository);
		mainClass.run(menu);
	}
}

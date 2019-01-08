package com.marcelo.controle;

import com.marcelo.controle.domain.Funcionario;
import com.marcelo.controle.domain.HoraBanco;
import com.marcelo.controle.repository.FuncionarioRepository;
import com.marcelo.controle.repository.HoraBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static java.util.Arrays.asList;

@SpringBootApplication
public class ControleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ControleApplication.class, args);
	}


	LocalTime time = LocalTime.of(9,2,15);
	LocalDate date = LocalDate.now();



	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private HoraBancoRepository horaBancoRepository;

	@Override
	public void run(String... args) throws Exception {

		Funcionario funcionario1 = new Funcionario(null, "Marcos Alberto", "Marketing", "Analista de Marketing");

		HoraBanco reg1 = new HoraBanco(null, "Terça", time, date, funcionario1);

		funcionario1.getRegistro().addAll(Arrays.asList(reg1));



		funcionarioRepository.saveAll(asList(funcionario1));
		horaBancoRepository.saveAll(asList(reg1));



	}



}


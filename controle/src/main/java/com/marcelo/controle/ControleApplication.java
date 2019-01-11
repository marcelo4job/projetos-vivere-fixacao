package com.marcelo.controle;

import com.marcelo.controle.domain.enums.DiasSemana;
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


	LocalTime time = LocalTime.now();
	LocalDate date = LocalDate.now();

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private HoraBancoRepository horaBancoRepository;

	@Override
	public void run(String... args) throws Exception {

		Funcionario funcionario1 = new Funcionario(null, "Marcos Alberto", "Marketing", "Analista de Marketing");
		Funcionario funcionario2 = new Funcionario(null, "Mikael Anderson", "Comercial", "Analista Finenceiro");

		HoraBanco reg1 = new HoraBanco(null, DiasSemana.QUARTA, time, date, funcionario1);
		HoraBanco reg2 = new HoraBanco(null, DiasSemana.QUARTA, time, date, funcionario2);

		funcionario1.getRegistro().addAll(Arrays.asList(reg1));
		funcionario2.getRegistro().addAll(Arrays.asList(reg2));



		funcionarioRepository.saveAll(asList(funcionario1, funcionario2));
		horaBancoRepository.saveAll(asList(reg1, reg2));



	}



}


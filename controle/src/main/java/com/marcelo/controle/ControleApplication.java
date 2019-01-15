package com.marcelo.controle;

import com.marcelo.controle.domain.Record;
import com.marcelo.controle.domain.TimeBank;
import com.marcelo.controle.domain.enums.DiasSemana;
import com.marcelo.controle.domain.User;
import com.marcelo.controle.repository.UserRepository;
import com.marcelo.controle.repository.RecordRepository;
import com.marcelo.controle.repository.TimeBankRepository;
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
	private UserRepository userRepository;
	@Autowired
	private RecordRepository recordRepository;
	@Autowired
    private TimeBankRepository timeBankRepository;

	@Override
	public void run(String... args) throws Exception {

        TimeBank timeReg1 = new TimeBank(null, "Entrada");
        TimeBank timeReg2 = new TimeBank(null, "Saída Almoço");

		User user1 = new User(null, "Marcos Alberto", "Marketing", "Analista de Marketing");
		User user2 = new User(null, "Mikael Anderson", "Comercial", "Analista Finenceiro");

		Record reg1 = new Record(null, DiasSemana.QUARTA, time, date, user1, timeReg1);
        Record reg2 = new Record(null, DiasSemana.QUARTA, time, date, user2, timeReg2);

		user1.getRecords().addAll(Arrays.asList(reg1));
		user2.getRecords().addAll(Arrays.asList(reg2));

        timeReg1.getTimesBank().addAll(asList(reg1));
        timeReg2.getTimesBank().addAll(asList(reg2));

		userRepository.saveAll(asList(user1, user2));
        timeBankRepository.saveAll(asList(timeReg1, timeReg2));
		recordRepository.saveAll(asList(reg1,reg2));








    }



}


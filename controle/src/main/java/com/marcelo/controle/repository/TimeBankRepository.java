package com.marcelo.controle.repository;

import com.marcelo.controle.domain.TimeBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeBankRepository extends JpaRepository<TimeBank, Integer> {
}

package com.marcelo.pontocontrole.repository;

import com.marcelo.pontocontrole.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface RecordRepository extends JpaRepository<Record, Integer> {

    Record findById(int id);
    

}

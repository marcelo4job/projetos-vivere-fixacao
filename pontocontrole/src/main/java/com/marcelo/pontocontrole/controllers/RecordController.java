package com.marcelo.pontocontrole.controllers;

import com.marcelo.pontocontrole.models.Record;
import com.marcelo.pontocontrole.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/record")
public class RecordController {

    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/recordList")
    public List<Record> recordList(){

        return recordRepository.findAll();
    }

    @GetMapping("/record/{id}")
    public Record record4id(@PathVariable(value = "id")int id){

        return recordRepository.findById(id);
    }

    @PostMapping("/entry")
    public Record recordEntry(@RequestBody Record record){

        return recordRepository.save(record);

    }

    @PutMapping("/record/{id}")
    public Record recordUpdt(@PathVariable(value = "id")int id){

        return recordRepository.findById(id);
    }


}

package com.marcelo.controle.resources;

import com.marcelo.controle.domain.Funcionario;
import com.marcelo.controle.dto.FuncionarioDTO;
import com.marcelo.controle.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResources {


    @Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Funcionario obj = funcionarioService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioDTO objDto) {
        Funcionario obj = funcionarioService.fromDTO(objDto);
        obj = funcionarioService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getMatricula()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

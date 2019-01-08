package com.marcelo.controle.resources;

import com.marcelo.controle.domain.Funcionario;
import com.marcelo.controle.domain.HoraBanco;
import com.marcelo.controle.dto.FuncionarioDTO;
import com.marcelo.controle.dto.HoraBancoDTO;
import com.marcelo.controle.services.HoraBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/registros")
public class HoraBancoResources {


    @Autowired
    private HoraBancoService horaBancoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        HoraBanco obj = horaBancoService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody HoraBancoDTO objDto) {
        HoraBanco obj = horaBancoService.fromDTO(objDto);
        obj = horaBancoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> Update(@Valid @RequestBody HoraBancoDTO objDto, @PathVariable Integer id) {
        HoraBanco obj = horaBancoService.fromDTO(objDto);
        obj.setId(id);
        obj = horaBancoService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        horaBancoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<HoraBancoDTO>> findAll() {
        List<HoraBanco> list = horaBancoService.findAll();
        List<HoraBancoDTO> listDto = list.stream().map(obj -> new HoraBancoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }

}

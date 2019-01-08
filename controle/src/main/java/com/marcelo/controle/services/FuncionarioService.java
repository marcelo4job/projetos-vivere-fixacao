package com.marcelo.controle.services;


import com.marcelo.controle.domain.Funcionario;
import com.marcelo.controle.dto.FuncionarioDTO;
import com.marcelo.controle.repository.FuncionarioRepository;
import com.marcelo.controle.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario find(Integer id){
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + Funcionario.class.getName()));
}

    public Funcionario insert(Funcionario obj){
        obj.setMatricula(null);
        return funcionarioRepository.save(obj);
    }

    public Funcionario fromDTO(FuncionarioDTO objDto){
        return  new Funcionario(objDto.getMatricula(), objDto.getNome(), objDto.getSetor(), objDto.getCargo());
    }

}

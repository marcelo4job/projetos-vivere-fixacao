package com.marcelo.controle.services;


import com.marcelo.controle.domain.Funcionario;
import com.marcelo.controle.domain.HoraBanco;
import com.marcelo.controle.domain.enums.DiasSemana;
import com.marcelo.controle.dto.FuncionarioDTO;
import com.marcelo.controle.dto.FuncionarioNewDTO;
import com.marcelo.controle.repository.FuncionarioRepository;
import com.marcelo.controle.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario find(Integer id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + Funcionario.class.getName()));
    }

    public Funcionario insert(Funcionario obj) {
        obj.setMatricula(null);
        return funcionarioRepository.save(obj);
    }

    public Funcionario fromDTO(FuncionarioDTO objDto) {
        return new Funcionario(objDto.getMatricula(), objDto.getNome(), objDto.getSetor(), objDto.getCargo());
    }

    public Funcionario fromDTO(FuncionarioNewDTO objDTO){
        Funcionario funcionario = new Funcionario(null, objDTO.getNome(), objDTO.getSetor(), objDTO.getCargo());
        HoraBanco reg = new HoraBanco(null, DiasSemana.toEnum(objDTO.getDia()), objDTO.getHora(), objDTO.getDate(),objDTO.getIdRegistro());
        funcionario.getRegistro().add(reg);
        return funcionario;

    }

    public Funcionario update(Funcionario obj) {
        Funcionario newObj = find(obj.getMatricula());
        updateData(newObj, obj);
        return funcionarioRepository.save(newObj);
    }

    private void updateData(Funcionario newObj, Funcionario obj){
        newObj.setNome(obj.getNome());
        newObj.setCargo(obj.getCargo());
        newObj.setSetor(obj.getSetor());
    }

    public void delete(Integer id){
        find(id);
        try{
            funcionarioRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel excluir um fucionario com registro no banco de horas");
        }

    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
}

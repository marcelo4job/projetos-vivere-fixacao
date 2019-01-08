package com.marcelo.controle.services;


import com.marcelo.controle.domain.Funcionario;
import com.marcelo.controle.domain.HoraBanco;
import com.marcelo.controle.dto.FuncionarioDTO;
import com.marcelo.controle.dto.HoraBancoDTO;
import com.marcelo.controle.repository.HoraBancoRepository;
import com.marcelo.controle.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoraBancoService {

    @Autowired
    private HoraBancoRepository horaBancoRepository;

    public HoraBanco find(Integer id) {
        Optional<HoraBanco> obj = horaBancoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo" + HoraBanco.class.getName()));
    }

    public HoraBanco insert(HoraBanco obj) {
        obj.setId(null);
        return horaBancoRepository.save(obj);
    }

    public HoraBanco fromDTO(HoraBancoDTO objDto) {
        return new HoraBanco(objDto.getId(),objDto.getDia(),objDto.getHora(),objDto.getDate(),objDto.getFuncionario());
    }

    public HoraBanco update(HoraBanco obj) {
        HoraBanco newObj = find(obj.getId());
        updateData(newObj, obj);
        return horaBancoRepository.save(newObj);
    }

    private void updateData(HoraBanco newObj, HoraBanco obj){
        newObj.setDia(obj.getDia());
        newObj.setHora(obj.getHora());
        newObj.setDate(obj.getDate());
        newObj.setFuncionario(obj.getFuncionario());
    }

    public void delete(Integer id){
        find(id);
        try{
            horaBancoRepository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel excluir um fucionario com registro no banco de horas");
        }

    }

    public List<HoraBanco> findAll(){
        return horaBancoRepository.findAll();
    }
}

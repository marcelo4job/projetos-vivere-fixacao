package com.marcelo.cursomc.services;

import com.marcelo.cursomc.domain.Categoria;
import com.marcelo.cursomc.domain.Pedido;
import com.marcelo.cursomc.repositories.CategoriaRepository;
import com.marcelo.cursomc.repositories.PedidoRepository;
import com.marcelo.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "O objeto não encontrado! Id: " + id + ", Tipo:" + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return categoriaRepository.save(obj);
    }
}

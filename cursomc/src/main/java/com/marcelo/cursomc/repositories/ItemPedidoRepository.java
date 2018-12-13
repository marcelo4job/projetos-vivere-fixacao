package com.marcelo.cursomc.repositories;

import com.marcelo.cursomc.domain.enums.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {



}

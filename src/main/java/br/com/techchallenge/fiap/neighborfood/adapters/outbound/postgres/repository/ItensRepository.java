/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.pedido.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ItensRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findAllById(Long id);

    Set<ItemEntity> findByIdPedido(Long id);
}

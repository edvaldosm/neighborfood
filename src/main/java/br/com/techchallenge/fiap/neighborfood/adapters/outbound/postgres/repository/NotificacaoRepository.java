
/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.pedido.MimoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.pedido.NotificacaoEntity;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Mimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Long> {

    MimoEntity findByIdUsuario(Mimo mimoRequest);
}

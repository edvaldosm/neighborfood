/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.inbound.notificacao;

import br.com.techchallenge.fiap.neighborfood.application.core.domain.Mimo;

public interface EnviaMimosInboundPort {

    br.com.techchallenge.fiap.neighborfood.domain.dto.MimoDTO enviaMimosExecute(Mimo mimoRequest);

}

/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.inbound.notificacao;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.dto.MimoDTO;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Mimo;

public interface EnviaMimosInboundPort {

    MimoDTO enviaMimosExecute(Mimo mimoRequest);

}

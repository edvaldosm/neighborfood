/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.inbound.notificacao;


import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.dto.MimoDTO;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Mimo;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Notificacao;

public interface NotificationUseCasePort {

    MimoDTO enviaMimosExecute(Mimo mimoRequest);
    Notificacao notificaExecute(Mimo mimoRequest);
}

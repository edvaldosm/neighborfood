/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.application.core.domain.Mimo;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Notificacao;

import java.util.List;

public interface NotificationUseCaseAdapterPort {

    Mimo enviaMimos(Mimo mimoRequest);
    Notificacao notifica(Notificacao notificacao);
    List<Notificacao> findAll();
}

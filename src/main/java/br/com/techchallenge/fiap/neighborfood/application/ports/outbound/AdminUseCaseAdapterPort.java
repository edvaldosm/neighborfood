/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;

import java.util.List;

public interface AdminUseCaseAdapterPort {
    List<AcompanhamentoResponse> listaPedidos(Long idAdmin);
}

/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;

import java.util.List;

public interface AdminUseCaseAdapterPort {
    List<AcompanhamentoResponse> listaPedidos(Long idAdmin);
}

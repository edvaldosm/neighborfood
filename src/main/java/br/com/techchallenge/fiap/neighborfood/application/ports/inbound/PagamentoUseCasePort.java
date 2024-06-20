/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Pagamento;

public interface PagamentoUseCasePort {

    AcompanhamentoResponse pagamentoExecute(Pagamento pagamento);
}

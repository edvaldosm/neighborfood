/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.Pagamento;

public interface PagamentoUseCasePort {

    AcompanhamentoResponse pagamentoExecute(Pagamento pagamento);
}
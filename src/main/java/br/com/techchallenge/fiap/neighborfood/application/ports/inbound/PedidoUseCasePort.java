/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.PedidoRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Item;

import java.util.Set;

public interface PedidoUseCasePort {

    Object menuOpcionaisExecute();

    AcompanhamentoResponse pedidoExecute(PedidoRequest pedido);

    AcompanhamentoResponse atualizarPedidoExecute(PedidoRequest pedido);

    void removeItensExecute(Set<Item> itens);
}

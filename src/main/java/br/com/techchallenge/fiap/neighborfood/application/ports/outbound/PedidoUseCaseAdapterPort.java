/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.pedido.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.estoque.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Item;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Pedido;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Produto;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.enums.Categoria;

import java.util.List;
import java.util.Set;

public interface PedidoUseCaseAdapterPort {

    Set<Produto> menuOpcionais(Categoria combo);

    AcompanhamentoResponse pedido(Pedido pedido);

    AcompanhamentoResponse atualizarPedido(Pedido pedido);

    Pedido commitUpdates(PedidoEntity pedidoEntity);

    void saveItens(Item item);

    void removeItens(Set<Item> itens);

    Set<Item> findAllById(Long id);

    Set<Item> findAllByIdPedido(Long id);

    Pedido findByIdPedido(Long id);

    Pedido findById(Long id);

    void salvaPagamento(PagamentoEntity entity);

    List<PedidoEntity> pedidosExecute();
}

/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.adaptes;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.enums.Status;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.AcompanhamentoChain;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.anemic.AcompanhamentoChainRecebidoImpl;
import br.com.techchallenge.fiap.neighborfood.application.ports.inbound.AcompanhamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.AcompanhamentoUseCaseAdapterPort;


public class AcompanhamentoPedidoAdapter extends AcompanhamentoChain
        implements AcompanhamentoUseCaseAdapterPort {

    private PedidoRepository pedidoRepository;
    private AcompanhamentoChain acompanhamentoChain;
    private AcompanhamentoUseCasePort acompanhamentoUseCasePort;

    public AcompanhamentoPedidoAdapter(PedidoRepository pedidoRepository, AcompanhamentoChain acompanhamentoChain, AcompanhamentoUseCasePort acompanhamentoUseCasePort) {
        this.pedidoRepository = pedidoRepository;
        this.acompanhamentoChain = acompanhamentoChain;
        this.acompanhamentoUseCasePort = acompanhamentoUseCasePort;
    }

    @Override
    public AcompanhamentoResponse getOrderStatus(Long idPedido) {
        return acompanhamentoUseCasePort.getOrderStatusExecute(idPedido);
    }


    @Override
    public String sms(Status Status) {
        return new AcompanhamentoChainRecebidoImpl(acompanhamentoChain).sms(Status);
    }


    @Override
    public void fluxoStatusPedido(Long idPedido, Status Status) {
        acompanhamentoUseCasePort.pedidoStatusExecute(idPedido, Status);
    }


    @Override
    public void pedidoStatus(Long idPedido, Status Status) {
        acompanhamentoUseCasePort.pedidoStatusExecute(idPedido, Status);
    }
}

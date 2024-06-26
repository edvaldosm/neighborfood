/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhamento;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.AcompanhamentoChain;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.anemic.AcompanhamentoChainRecebidoImpl;
import br.com.techchallenge.fiap.neighborfood.application.ports.inbound.AcompanhamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.PedidoUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.config.exception.PedidoException;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Pedido;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.enums.Status;

import java.util.Date;


public class AcompanhamentoUseCaseImpl implements AcompanhamentoUseCasePort {

    private final PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort;
    private final AcompanhamentoChain statusPedidoChain;

    public AcompanhamentoUseCaseImpl(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort, AcompanhamentoChain statusPedidoChain) {
        this.pedidoUseCaseAdapterPort = pedidoUseCaseAdapterPort;
        this.statusPedidoChain = statusPedidoChain;
    }

    @Override
    public AcompanhamentoResponse getOrderStatusExecute(Long idPedido) {

        Pedido pedido = new Pedido();
        try {
            pedido = pedidoUseCaseAdapterPort.findById(idPedido);

            if (pedido.getStatus().equals(Status.EM_PREPARACAO)) {
                this.pedidoStatusExecute(idPedido, Status.PRONTO);
                pedido.setStatus(Status.PRONTO);
            } else if (pedido.getStatus().equals(Status.PRONTO)) {
                this.fluxoStatusPedidoExecute(idPedido, Status.FINALIZADO);
                pedido.setStatus(Status.FINALIZADO);
            }
        } catch (Exception ex) {
            throw new PedidoException("Pedido não encontrado!");
        }
        return pedidoUseCaseAdapterPort.pedido(pedido);
    }

    @Override
    public String smsExecute(Status Status) {
        return new AcompanhamentoChainRecebidoImpl(statusPedidoChain).sms(Status);
    }


    @Override
    public void fluxoStatusPedidoExecute(Long idPedido, Status Status) {
        Pedido pedidoDTO = pedidoUseCaseAdapterPort.findById(idPedido);
        pedidoDTO.setStatus(Status);
        if (pedidoDTO.getStatus().equals(Status.FINALIZADO)) {
            pedidoDTO.setDataPedidoFim(new Date());
        }
        pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.domainFromEntity());

        System.out.println(this.smsExecute(pedidoDTO.getStatus()));
    }


    @Override
    public void pedidoStatusExecute(Long idPedido, Status Status) {
        Pedido pedidoDTO = pedidoUseCaseAdapterPort.findById(idPedido);
        pedidoDTO.setStatus(Status);
        Pedido pedidoDTO1 = pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.domainFromEntity());
        System.out.println(this.smsExecute(pedidoDTO1.getStatus()));
    }

}

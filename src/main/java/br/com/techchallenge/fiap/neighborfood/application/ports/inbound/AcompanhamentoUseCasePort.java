/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.enums.Status;
import org.springframework.context.annotation.Bean;

public interface AcompanhamentoUseCasePort {

    @Bean
    AcompanhamentoResponse getOrderStatusExecute(Long idPedido);

    @Bean
    String smsExecute(Status Status);

    @Bean
    void fluxoStatusPedidoExecute(Long idPedido, Status Status);

    @Bean
    void pedidoStatusExecute(Long idPedido, Status Status);
}

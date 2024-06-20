/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain;

import br.com.techchallenge.fiap.neighborfood.application.core.domain.enums.Status;

public abstract class AcompanhamentoChain {

    private AcompanhamentoChain StatusPedidoChain;

    public abstract String sms(Status Status);
}

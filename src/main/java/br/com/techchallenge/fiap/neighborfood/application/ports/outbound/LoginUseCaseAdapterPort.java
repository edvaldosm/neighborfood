/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.AdminRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Admin;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Cliente;

public interface LoginUseCaseAdapterPort {

    Cliente login(ClienteRequest clienteRequest);

    Cliente cadastro(ClienteRequest clienteRequest);

    Admin loginAdm(AdminRequest adminRequest);

    Admin cadastroAdm(AdminRequest adminRequest);

}

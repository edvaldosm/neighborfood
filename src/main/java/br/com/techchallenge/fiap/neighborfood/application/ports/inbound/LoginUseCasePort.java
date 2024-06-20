/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.AdminRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Admin;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Cliente;

public interface LoginUseCasePort {

    Cliente loginExecute(ClienteRequest clienteRequest);

    Cliente cadastroExecute(ClienteRequest clienteRequest);

    Admin loginAdmExecute(AdminRequest adminRequest);

    Admin cadastroAdmExecute(AdminRequest adminRequest);

}

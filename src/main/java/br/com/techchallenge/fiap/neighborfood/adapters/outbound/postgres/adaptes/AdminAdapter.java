/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.adaptes;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.application.ports.inbound.AdminUseCasePort;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.AdminUseCaseAdapterPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminAdapter implements AdminUseCaseAdapterPort {

    private UserAdapter userAdapter;
    private AdminUseCasePort adminUseCasePort;

    public AdminAdapter(UserAdapter userAdapter, AdminUseCasePort adminUseCasePort) {
        this.userAdapter = userAdapter;
        this.adminUseCasePort = adminUseCasePort;
    }

    @Override
    public List<AcompanhamentoResponse> listaPedidos(Long idAdmin) {
        return adminUseCasePort.listaPedidosExecute(idAdmin);
    }
}

/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.adaptes;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.AdminRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.AdmRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.admin.AdminEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.cliente.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Admin;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Cliente;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.LoginUseCaseAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class LoginAdapter implements LoginUseCaseAdapterPort {

    private AdmRepository admRepository;
    private ClienteRepository clienteRepository;

    public LoginAdapter(AdmRepository admRepository, ClienteRepository clienteRepository) {
        this.admRepository = admRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente login(ClienteRequest clienteRequest) {
        return new Cliente().fromModel(clienteRepository.findByCpf(clienteRequest.getCpf()));
    }


    @Override
    public Cliente cadastro(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        ClienteEntity entity = cliente.fromEntity(clienteRequest);
        return new Cliente().fromModel(clienteRepository.save(entity));
    }


    @Override
    public Admin loginAdm(AdminRequest adminRequest) {
        return new Admin().fromModel(admRepository.findByCpf(adminRequest.getCpf()));
    }


    @Override
    public Admin cadastroAdm(AdminRequest adminRequest) {

        AdminEntity adminEntity = new Admin().fromEntity(adminRequest);
        return new Admin().fromModel(admRepository.save(adminEntity));
    }
}

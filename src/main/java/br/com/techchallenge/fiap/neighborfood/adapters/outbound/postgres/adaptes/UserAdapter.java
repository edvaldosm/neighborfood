/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.adaptes;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.AdmRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.admin.AdminEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.cliente.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Admin;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    private AdmRepository admRepository;
    private ClienteRepository clienteRepository;

    public UserAdapter(AdmRepository admRepository, ClienteRepository clienteRepository) {
        this.admRepository = admRepository;
        this.clienteRepository = clienteRepository;
    }


    public Cliente clienteById(Long idCliente) {
        ClienteEntity entity = clienteRepository.findById(idCliente).get();
        return new Cliente().fromModel(entity);
    }

    public Cliente clienteByCpf(String cpf) {
        return new Cliente().fromModel(clienteRepository.findByCpf(cpf));
    }

    public Admin adminByCpf(String cpf) {
        return new Admin().fromModel(admRepository.findByCpf(cpf));
    }

    public Admin adminById(Long idAdmin) {
        return new Admin().fromModel(admRepository.findById(idAdmin).orElse(new AdminEntity()));
    }

}

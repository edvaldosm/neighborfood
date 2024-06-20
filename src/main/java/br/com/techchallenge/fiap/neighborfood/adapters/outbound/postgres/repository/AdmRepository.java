/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<AdminEntity, Long> {

    AdminEntity findByCpf(String cpf);
}

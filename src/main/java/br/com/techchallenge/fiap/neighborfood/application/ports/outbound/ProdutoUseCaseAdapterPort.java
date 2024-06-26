/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.application.core.domain.Produto;

import java.util.Set;

public interface ProdutoUseCaseAdapterPort {

    Object gerenciaEstoque(Long idAmdin);

    Object repoemEstoque(Set<Produto> produtos);

    Produto findById(Long idProduto);

    void deleteById(Long idProduto);

    void deleteAll(Set<Produto> produtos);

    void deleteByNome(String nome);
}

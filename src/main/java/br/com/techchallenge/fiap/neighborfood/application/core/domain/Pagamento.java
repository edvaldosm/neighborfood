/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.application.core.domain;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.pedido.PagamentoEntity;

public class Pagamento {

    private Long id;
    private Long idPedido;
    private Boolean pagou;

    public Pagamento() {
    }

    public Pagamento(Long id, Long idPedido, Boolean pagou) {
        this.id = id;
        this.idPedido = idPedido;
        this.pagou = pagou;
    }


    public PagamentoEntity fromEntity(Pagamento pagamento) {
        PagamentoEntity entity = new PagamentoEntity();
        entity.setId(pagamento.getId());
        entity.setPagou(pagamento.getPagou());
        entity.setIdPedido(pagamento.getIdPedido());
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Boolean getPagou() {
        return pagou;
    }

    public void setPagou(Boolean pagou) {
        this.pagou = pagou;
    }
}

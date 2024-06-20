/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.PedidoRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.estoque.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Item;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Pedido;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.enums.Status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AcompanhamentoResponse {

    private PedidoRequest pedidoRequest;
    private Status status;
    private BigDecimal total;

    public AcompanhamentoResponse() {
    }

    public AcompanhamentoResponse(PedidoRequest pedidoRequest, Status status, BigDecimal total) {
        this.pedidoRequest = pedidoRequest;
        this.status = status;
        this.total = total;
    }

    public br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO pedidoFromResponse() {
        br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO response = new br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO();
        br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoRequestDTO requestDTO = new br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoRequestDTO();
        requestDTO.setIdCliente(this.pedidoRequest.getIdCliente());
        List<br.com.techchallenge.fiap.neighborfood.domain.dto.ItemPedido> itemPedidoList = new ArrayList<>();
        this.pedidoRequest.getItensPedido().forEach(item -> {

            br.com.techchallenge.fiap.neighborfood.domain.dto.ItemPedido itemPedido = new br.com.techchallenge.fiap.neighborfood.domain.dto.ItemPedido();
            itemPedido.setId(item.getId());
            itemPedido.setIdPedido(item.getIdPedido());

            br.com.techchallenge.fiap.neighborfood.domain.dto.ProdutoDTO dto = new br.com.techchallenge.fiap.neighborfood.domain.dto.ProdutoDTO();
            dto.setId(item.getId());
            dto.setNome(item.getNome());
            dto.setDescricao(item.getDescricao());
            dto.setPreco(item.getPreco());
            dto.setCategoria(br.com.techchallenge.fiap.neighborfood.domain.dto.CategoriaDTO.valueOf(item.getCategoria().toString()));
            dto.setImg(item.getImg());
            itemPedido.setProduto(dto);
            itemPedidoList.add(itemPedido);
        });
        requestDTO.setItensPedido(itemPedidoList);
        response.setPedido(requestDTO);
        response.getPedido().setId(this.pedidoRequest.getId());
        response.setStatus(br.com.techchallenge.fiap.neighborfood.domain.dto.StatusPedidoDTO.valueOf(this.status.toString()));
        response.setTotal(this.total);
        return response;
    }

    public AcompanhamentoResponse pedidoEntityFromResponse(PedidoEntity pedidoEntity) {
        AcompanhamentoResponse response = new AcompanhamentoResponse();
        Set<Item> itensPedido = new HashSet<>();
        itensPedido.forEach(item -> item.setIdPedido(pedidoEntity.getId()));
        PedidoRequest request = new PedidoRequest();
        request.setIdCliente(pedidoEntity.getIdCliente());

        pedidoEntity.getItensProdutos().forEach(item -> {
            Item item1 = new Item();
            item1.setId(item.getId());
            item1.setIdPedido(item.getIdPedido());
            item1.setIdProduto(item.getIdProduto());
            item1.setNome(item.getNome());
            item1.setDescricao(item.getDescricao());
            item1.setCategoria(item.getCategoria());
            item1.setPreco(item.getPreco());
            item1.setImg(item.getImg());
            itensPedido.add(item1);
        });
        request.setItensPedido(itensPedido);
        response.setStatus(pedidoEntity.getStatus());
        response.setTotal(pedidoEntity.getTotal());
        response.convertPedidoRequest(request);
        request.setId(pedidoEntity.getId());
        return response;
    }

    public PedidoRequest getPedidoRequest() {
        return pedidoRequest;
    }

    public void convertPedidoRequest(PedidoRequest pedidoRequest) {
        this.pedidoRequest = pedidoRequest;
    }

    public void setPedidoRequest(PedidoRequest pedidoRequest) {
        this.pedidoRequest = pedidoRequest;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PedidoRequest convertPedidoRequest(Pedido pedido) {
        PedidoRequest request = new PedidoRequest();
        List<Item> itens =  new ArrayList<>();
        request.setId(pedido.getId());
        request.setIdCliente(pedido.getIdCliente());
        pedido.getItensProdutos().forEach(item -> {
            Item produto = new Item();
            produto.setId(item.getId());
            produto.setIdProduto(item.getIdProduto());
            produto.setIdPedido(item.getIdPedido());
            produto.setNome(item.getNome());
            produto.setCategoria(item.getCategoria());
            produto.setDescricao(item.getDescricao());
            produto.setPreco(item.getPreco());
            produto.setImg(item.getImg());
            itens.add(produto);
        });

        request.setItensPedido(new HashSet<>(itens));
        return request;
    }
}








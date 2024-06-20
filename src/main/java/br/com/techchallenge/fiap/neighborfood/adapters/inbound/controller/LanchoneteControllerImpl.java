/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller;


import _generated_sources_swagger.NeighborfoodApi;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.AdminRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.request.PedidoRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.controller.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Mimo;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Pagamento;
import br.com.techchallenge.fiap.neighborfood.application.ports.inbound.*;
import br.com.techchallenge.fiap.neighborfood.application.ports.inbound.notificacao.NotificationUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LanchoneteControllerImpl implements NeighborfoodApi {

    private final AcompanhamentoUseCasePort acompanhamentoUseCasePort;
    private final AdminUseCasePort adminUseCasePort;
    private final ProdutoUseCasePort estoqueUseCasePort;
    private final LoginUseCasePort loginUseCasePort;
    private final NotificationUseCasePort notificationUseCasePort;
    private final PagamentoUseCasePort pagamentoUseCasePort;
    private final PedidoUseCasePort pedidoUseCasePort;

    public LanchoneteControllerImpl(AcompanhamentoUseCasePort acompanhamentoUseCasePort, AdminUseCasePort adminUseCasePort, ProdutoUseCasePort estoqueUseCasePort, LoginUseCasePort loginUseCasePort, NotificationUseCasePort notificationUseCasePort, PagamentoUseCasePort pagamentoUseCasePort, PedidoUseCasePort pedidoUseCasePort) {
        this.acompanhamentoUseCasePort = acompanhamentoUseCasePort;
        this.adminUseCasePort = adminUseCasePort;
        this.estoqueUseCasePort = estoqueUseCasePort;
        this.loginUseCasePort = loginUseCasePort;
        this.notificationUseCasePort = notificationUseCasePort;
        this.pagamentoUseCasePort = pagamentoUseCasePort;
        this.pedidoUseCasePort = pedidoUseCasePort;
    }

    /**
     * POST /neighborfood/login : Se cadastrar, logar
     * Identificação do cliente
     *
     * @param clienteRequestDTO Identifica um cliente logado (optional)
     * @return Usuário logado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> login(br.com.techchallenge.fiap.neighborfood.domain.dto.ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.ok(
                loginUseCasePort.loginExecute(new ClienteRequest().dtoFromDomain(clienteRequestDTO)));
    }

    /**
     * POST /neighborfood/painel/login : Cadastrar adm, logar adm
     * Identificação do adm
     *
     * @param adminRequestDTO Identifica um adminsitrador logado (optional)
     * @return Usuário logado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> loginAdm(br.com.techchallenge.fiap.neighborfood.domain.dto.AdminRequestDTO adminRequestDTO) {
        return ResponseEntity.ok(
                loginUseCasePort.loginAdmExecute(new AdminRequest().dtoFromDomain(adminRequestDTO)));
    }

    /**
     * POST /neighborfood/cadastro : Se cadastrar, logar
     * Cria cliente
     *
     * @param clienteRequestDTO Cria um novo cliente (optional)
     * @return Usuário logado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> register(br.com.techchallenge.fiap.neighborfood.domain.dto.ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.ok(
                loginUseCasePort.cadastroExecute(new ClienteRequest().dtoFromDomain(clienteRequestDTO)));
    }

    /**
     * POST /neighborfood/painel/cadastro : Se cadastrar, logar
     * Cria cliente
     *
     * @param adminRequestDTO Cria um novo administrador (optional)
     * @return Usuário cadastrao (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> registerAdm(br.com.techchallenge.fiap.neighborfood.domain.dto.AdminRequestDTO adminRequestDTO) {
        return ResponseEntity.ok(
                loginUseCasePort.cadastroAdmExecute(new AdminRequest().dtoFromDomain(adminRequestDTO)));
    }


    /**
     * GET /neighborfood/painel/produto/cadastro/{idAdmin} : Cadastra produtos
     * Cadastra produtos em lote
     *
     * @param idAdmin id identificador do administrador (required)
     * @return Produtos cadastrados (status code 200)
     * or Id inválido (status code 400)
     * or Produto inválido (status code 404)
     */
    @Override
    public ResponseEntity<Object> registerProduct(Long idAdmin) {
        return ResponseEntity.ok(estoqueUseCasePort.gerenciaEstoqueExecute(idAdmin));
    }


    /**
     * GET /neighborfood/menu : Apresenta o menu com itens opcionais
     * menu de opções
     *
     * @return Apresenta os itens de menu (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> menu() {
        return ResponseEntity.ok(pedidoUseCasePort.menuOpcionaisExecute());
    }

    @Override
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO> order(br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoRequestDTO pedidoRequest) {
        AcompanhamentoResponse response =
                pedidoUseCasePort.pedidoExecute(new PedidoRequest().dtoFromRequest(pedidoRequest));
        return ResponseEntity.ok(response.pedidoFromResponse());
    }

    /**
     * POST /neighborfood/pagamento : Realiza o pagamento do pedido
     * Realiza pagamento
     *
     * @param pagamentoDTO (required)
     * @return pagamento realizado com sucesso. (status code 200)
     * or Id inválido (status code 400)
     * or Pedido não encontrado (status code 404)
     */
    @Override
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO> payment(br.com.techchallenge.fiap.neighborfood.domain.dto.PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setIdPedido(pagamentoDTO.getIdPedido());
        pagamento.setPagou(pagamentoDTO.getPagou());
        AcompanhamentoResponse response = pagamentoUseCasePort.pagamentoExecute(pagamento);
        return ResponseEntity.ok(response.pedidoFromResponse());
    }


    /**
     * GET /neighborfood/acompanhamento/{idPedido} : Procura o status de um pedido
     * Retorna o status de um pedido
     *
     * @param idPedido id do pedido (required)
     * @return successful operation (status code 200)
     * or Id inválido (status code 400)
     * or Pedido não encontrado (status code 404)
     */
    @Override
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO> findOrderByIdOrder(Long idPedido) {
        AcompanhamentoResponse orderStatusExecute = acompanhamentoUseCasePort.getOrderStatusExecute(idPedido);
        return ResponseEntity.ok(orderStatusExecute.pedidoFromResponse());
    }

    /**
     * GET /neighborfood/painel/pedido/lista/{idAdmin} : Lista de pedidos efetuados contendo seus clientes, itens, status, valores e data de pedido e data de entrega.
     * Lista os pedidos recebidos
     *
     * @param idAdmin id identificador do administrador (required)
     * @return Lista de pedidos (status code 200)
     * or Id inválido (status code 400)
     * or Mimo não disponível (status code 404)
     */
    @Override
    public ResponseEntity<List<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO>> listOrders(Long idAdmin) {
        List<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO> statusDosPedidos = new ArrayList<>();
        List<AcompanhamentoResponse> acompanhamentoResponses = adminUseCasePort.listaPedidosExecute(idAdmin);

        acompanhamentoResponses.forEach(resp ->{
            statusDosPedidos.add(resp.pedidoFromResponse());
        });
        return ResponseEntity.ok(statusDosPedidos);
    }

    /**
     * POST /neighborfood/painel/cliente : Envia mimo ao último cliente que realizou um pedido
     * Envia mimo ao cliente
     *
     * @param mimoRequestDTO (required)
     * @return Mimo enviado (status code 200)
     * or Id inválido (status code 400)
     * or Mimo não disponível (status code 404)
     */
    @Override
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.MimoDTO> sendBonus(br.com.techchallenge.fiap.neighborfood.domain.dto.MimoRequestDTO mimoRequestDTO) {
        Mimo mimo = new Mimo();
        mimo.setIdUsuario(mimoRequestDTO.getIdCliente());
        return ResponseEntity.ok(notificationUseCasePort.enviaMimosExecute(mimo));
    }

    /**
     * PUT /neighborfood/pedido/update : Atualizar um pedido
     * Atualizar itens de um pedido já realizado
     *
     * @param pedidoDTO atualiar um  pedido (optional)
     * @return Pedido atualizado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponseDTO> updateOrder(br.com.techchallenge.fiap.neighborfood.domain.dto.PedidoRequestDTO pedidoDTO) {
        AcompanhamentoResponse response = pedidoUseCasePort.atualizarPedidoExecute(new PedidoRequest().dtoFromRequest(pedidoDTO));
        return ResponseEntity.ok(response.pedidoFromResponse());
    }


}

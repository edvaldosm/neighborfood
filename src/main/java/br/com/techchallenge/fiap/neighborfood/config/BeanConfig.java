/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.config;


import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.adaptes.UserAdapter;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.AcompanhamentoChain;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.anemic.AcompanhamentoChainFinalizadoImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.anemic.AcompanhamentoChainPreparacaoImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.anemic.AcompanhamentoChainProntoImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhachain.anemic.AcompanhamentoChainRecebidoImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.acompanhamento.AcompanhamentoUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.admin.AdmUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.login.LoginUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.notificacao.NotificacaoUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.pagamento.PagamentoUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.pedido.PedidoUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.application.core.usecase.produto.ProdutoUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.application.ports.inbound.*;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.LoginUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.NotificationUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.PedidoUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.ProdutoUseCaseAdapterPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {


    @Bean
    public AcompanhamentoUseCasePort acompanhamentoUseCaseImpl(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort, AcompanhamentoChain statusPedidoChain) {
        return new AcompanhamentoUseCaseImpl(pedidoUseCaseAdapterPort, statusPedidoChain);
    }

    @Bean
    public AcompanhamentoChain acompanhamentoChainPronto() {
        return new AcompanhamentoChainProntoImpl();
    }

    @Bean
    @Primary
    public AcompanhamentoChain acompanhamentoChainRecebido() {
        return new AcompanhamentoChainRecebidoImpl();
    }

    @Bean
    public AcompanhamentoChain acompanhamentoChainPreparacao() {
        return new AcompanhamentoChainPreparacaoImpl();
    }

    @Bean
    public AcompanhamentoChain acompanhamentoChainFinalizado() {
        return new AcompanhamentoChainFinalizadoImpl();
    }

    @Bean
    public AdminUseCasePort adminUseCasePort(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort, UserAdapter userAdapter) {
        return new AdmUseCaseImpl(pedidoUseCaseAdapterPort, userAdapter);
    }

    @Bean
    public ProdutoUseCasePort estoqueUseCasePort(ProdutoUseCaseAdapterPort estoqueUseCaseAdapterPort,
                                                 LoginUseCaseAdapterPort loginAdapter, UserAdapter userdapter) {
        return new ProdutoUseCaseImpl(estoqueUseCaseAdapterPort, loginAdapter, userdapter);
    }

    @Bean
    public LoginUseCasePort loginUseCasePort(LoginUseCaseAdapterPort loginAdapterPort,
                                             NotificationUseCaseAdapterPort notificacaoAdapter,
                                             UserAdapter userAdapter) {
        return new LoginUseCaseImpl(loginAdapterPort, notificacaoAdapter, userAdapter);
    }

    @Bean

    public NotificationUseCasePort notificationUseCasePort(NotificationUseCaseAdapterPort notificacaoAdapterPort, ClienteRepository clienteRepository) {
        return new NotificacaoUseCaseImpl(notificacaoAdapterPort, clienteRepository);
    }

    @Bean
    public PagamentoUseCasePort pagamentoUseCasePort(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort, AcompanhamentoUseCasePort acompanhamentoUseCasePort) {
        return new PagamentoUseCaseImpl(pedidoUseCaseAdapterPort, acompanhamentoUseCasePort);
    }

    @Bean
    public PedidoUseCasePort pedidoUseCasePort(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort,
                                               ProdutoUseCaseAdapterPort estoqueUseCaseAdapterPort,
                                               NotificationUseCaseAdapterPort notificationUseCaseAdapterPort,
                                               AcompanhamentoUseCasePort acompanhamentoUseCasePort,
                                               UserAdapter userAdapter) {
        return new PedidoUseCaseImpl(pedidoUseCaseAdapterPort, estoqueUseCaseAdapterPort,
                notificationUseCaseAdapterPort, acompanhamentoUseCasePort, userAdapter);
    }
}

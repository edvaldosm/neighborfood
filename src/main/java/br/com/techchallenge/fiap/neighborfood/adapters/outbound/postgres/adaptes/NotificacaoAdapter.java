/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.adaptes;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.MimoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.repository.NotificacaoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.pedido.MimoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.postgres.entities.pedido.NotificacaoEntity;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Mimo;
import br.com.techchallenge.fiap.neighborfood.application.core.domain.Notificacao;
import br.com.techchallenge.fiap.neighborfood.application.ports.outbound.NotificationUseCaseAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificacaoAdapter implements NotificationUseCaseAdapterPort {

    private NotificacaoRepository notificacaoRepository;
    private MimoRepository mimoRepository;

    public NotificacaoAdapter(NotificacaoRepository notificacaoRepository, MimoRepository mimoRepository) {
        this.notificacaoRepository = notificacaoRepository;
        this.mimoRepository = mimoRepository;
    }

    @Override
    @Transactional
    public Mimo enviaMimos(Mimo mimoRequest) {
        MimoEntity entity = new MimoEntity();
        entity.setIdUsuario(mimoRequest.getIdUsuario());
        entity.setCodigo(mimoRequest.getCodigo());
        entity.setDescricao(mimoRequest.getDescricao());
        MimoEntity save = mimoRepository.save(entity);
        return new Mimo().fromModel(save);
    }


    @Override
    public Notificacao notifica(Notificacao notificacao) {
        Notificacao alerta = new Notificacao();
        NotificacaoEntity save = notificacaoRepository.save(alerta.fromEntity(notificacao));
        return alerta.entityfromDomain(save);
    }


    @Override
    public List<Notificacao> findAll() {
        List<Notificacao> lista = new ArrayList<>();
        notificacaoRepository.findAll().forEach(sms -> {
            lista.add(new Notificacao().entityfromDomain(sms));
        });
        return lista;
    }
}

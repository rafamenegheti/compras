package io.github.rafamenegheti.icompras.pedidos.service;

import io.github.rafamenegheti.icompras.pedidos.client.ServicoBancarioClient;
import io.github.rafamenegheti.icompras.pedidos.model.Pedido;
import io.github.rafamenegheti.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.rafamenegheti.icompras.pedidos.repository.PedidoRepository;
import io.github.rafamenegheti.icompras.pedidos.validator.PedidoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPeidoRepository;
    private final PedidoValidator validator;
    private final ServicoBancarioClient servicoBancarioClient;

    @Transactional
    public Pedido criarPedido(Pedido pedido){
        validator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolicitacaoPagamento(pedido);
        return pedido;
    }

    private void realizarPersistencia(Pedido pedido) {
        repository.save(pedido);
        itemPeidoRepository.saveAll(pedido.getItens());
    }

    private void enviarSolicitacaoPagamento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }
}

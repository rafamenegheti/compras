package io.github.rafamenegheti.icompras.pedidos.service;

import io.github.rafamenegheti.icompras.pedidos.model.Pedido;
import io.github.rafamenegheti.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.rafamenegheti.icompras.pedidos.repository.PedidoRepository;
import io.github.rafamenegheti.icompras.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPeidoRepository;
    private final PedidoValidator validator;

    public Pedido criarPedido(Pedido pedido){
        repository.save(pedido);
        itemPeidoRepository.saveAll(pedido.getItens());
        return pedido;
    }
}

package io.github.rafamenegheti.icompras.pedidos.repository;

import io.github.rafamenegheti.icompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}

package io.github.rafamenegheti.icompras.pedidos.repository;

import io.github.rafamenegheti.icompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

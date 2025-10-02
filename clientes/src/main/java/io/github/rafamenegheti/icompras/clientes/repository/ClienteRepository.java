package io.github.rafamenegheti.icompras.clientes.repository;

import io.github.rafamenegheti.icompras.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

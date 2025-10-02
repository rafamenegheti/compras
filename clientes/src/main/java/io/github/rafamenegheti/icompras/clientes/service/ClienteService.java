package io.github.rafamenegheti.icompras.clientes.service;

import ch.qos.logback.core.net.server.Client;
import io.github.rafamenegheti.icompras.clientes.model.Cliente;
import io.github.rafamenegheti.icompras.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Optional<Cliente> obterPorCodigo(Long codigo) {
        return repository.findById((codigo));
    }
}

package io.github.rafamenegheti.icompras.pedidos.model;

import io.github.rafamenegheti.icompras.pedidos.model.enums.TipoPagamento;
import lombok.Data;

@Data
public class DadosPagamento {
    private String dados;
    private TipoPagamento tipoPagamento;
}
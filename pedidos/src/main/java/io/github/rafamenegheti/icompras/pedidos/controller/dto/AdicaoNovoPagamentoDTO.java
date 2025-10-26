package io.github.rafamenegheti.icompras.pedidos.controller.dto;


import io.github.rafamenegheti.icompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(
        Long codigoPedido, String dados, TipoPagamento tipoPagamento) {
}
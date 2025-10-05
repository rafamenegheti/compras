package io.github.rafamenegheti.icompras.pedidos.controller.dto;


import io.github.rafamenegheti.icompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(String dados, TipoPagamento tipoPagamento) {
}
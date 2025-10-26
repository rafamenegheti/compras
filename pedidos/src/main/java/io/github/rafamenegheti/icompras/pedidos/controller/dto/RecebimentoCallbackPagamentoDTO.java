package io.github.rafamenegheti.icompras.pedidos.controller.dto;

public record RecebimentoCallbackPagamentoDTO(
        Long codigo, String chavePagamento, Boolean status, String observacoes ) {
}

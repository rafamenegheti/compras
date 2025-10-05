package io.github.rafamenegheti.icompras.pedidos.controller.mappers;

import io.github.rafamenegheti.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.rafamenegheti.icompras.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    ItemPedido map(ItemPedidoDTO dto);
}

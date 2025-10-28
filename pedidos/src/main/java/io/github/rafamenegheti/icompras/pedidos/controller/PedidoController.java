package io.github.rafamenegheti.icompras.pedidos.controller;

import io.github.rafamenegheti.icompras.pedidos.controller.dto.AdicaoNovoPagamentoDTO;
import io.github.rafamenegheti.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.rafamenegheti.icompras.pedidos.controller.mappers.PedidoMapper;
import io.github.rafamenegheti.icompras.pedidos.model.ErroResposta;
import io.github.rafamenegheti.icompras.pedidos.model.exception.ItemNaoEncontradoException;
import io.github.rafamenegheti.icompras.pedidos.model.exception.ValidationException;
import io.github.rafamenegheti.icompras.pedidos.publisher.DetalhePedidoMapper;
import io.github.rafamenegheti.icompras.pedidos.publisher.representation.DetalhePedidoRepresentation;
import io.github.rafamenegheti.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;
    private final DetalhePedidoMapper detalhePedidoMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto){
        try {
            var pedido = mapper.map(dto);
            var novoPedido = service.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido.getCodigo());
        } catch (ValidationException e) {
            var erro = new ErroResposta("Erro validação", e.getField(), e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }

    };

    @PostMapping("pagamentos")
    public ResponseEntity<Object> adicionarNovoPagamento(@RequestBody AdicaoNovoPagamentoDTO dto){
        try {
            service.adicionarNovoPagamento(dto.codigoPedido(), dto.dados(), dto.tipoPagamento());
        } catch (ItemNaoEncontradoException e) {
            var erro = new ErroResposta("Item não encontrado", "codigoPedido", e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }

        return ResponseEntity.noContent().build();
    };

    @GetMapping("{codigo}")
    public ResponseEntity<DetalhePedidoRepresentation> obterDetalhesPedidos(
            @PathVariable("codigo") Long codigo
    ) {
        return service
                .carregarDadosCompletosPedidos(codigo)
                .map(detalhePedidoMapper::map)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    };
}

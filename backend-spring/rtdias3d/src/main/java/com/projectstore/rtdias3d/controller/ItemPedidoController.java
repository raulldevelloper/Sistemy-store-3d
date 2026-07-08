package com.projectstore.rtdias3d.controller;

import com.projectstore.rtdias3d.entity.ItemPedido;
import com.projectstore.rtdias3d.repository.ItemPedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoController(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @GetMapping
    public List<ItemPedido> listar() {
        return itemPedidoRepository.findAll();
    }

    @PostMapping
    public ItemPedido salvar(@RequestBody ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }
}

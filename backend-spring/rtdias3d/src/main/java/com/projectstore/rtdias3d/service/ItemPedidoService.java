package com.projectstore.rtdias3d.service;

import com.projectstore.rtdias3d.entity.ItemPedido;
import com.projectstore.rtdias3d.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository repository;

    public ItemPedidoService(ItemPedidoRepository repository) {
        this.repository = repository;
    }

    public List<ItemPedido> listarTodos() {
        return repository.findAll();
    }

    public ItemPedido salvar(ItemPedido itemPedido) {
        return repository.save(itemPedido);
    }

    public ItemPedido buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}

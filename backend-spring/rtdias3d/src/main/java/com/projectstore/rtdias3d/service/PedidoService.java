package com.projectstore.rtdias3d.service;

import com.projectstore.rtdias3d.entity.Pedido;
import com.projectstore.rtdias3d.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}

package com.projectstore.rtdias3d.service;

import com.projectstore.rtdias3d.dtoS.ItemPedidoDTO;
import com.projectstore.rtdias3d.entity.ItemPedido;
import com.projectstore.rtdias3d.entity.Pedido;
import com.projectstore.rtdias3d.entity.Produto;
import com.projectstore.rtdias3d.repository.ItemPedidoRepository;
import com.projectstore.rtdias3d.repository.PedidoRepository;
import com.projectstore.rtdias3d.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository repository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public List<ItemPedido> listarTodos(){
        return repository.findAll();
    }

    public ItemPedido salvar(ItemPedidoDTO dto){

        Pedido pedido = pedidoRepository.findById(dto.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado  " +
                        "/ Order not found"));

        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado" +
                        " / Product not found"));

        ItemPedido item = new ItemPedido();

        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(dto.getQuantidade());
        item.setPreco(dto.getPreco());

        return repository.save(item);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    public ItemPedido atualizar(Integer id, ItemPedidoDTO dto){

        ItemPedido item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado / Item not found"));

        Pedido pedido = pedidoRepository.findById(dto.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado / Order not found"));

        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado / Product not found"));

        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(dto.getQuantidade());
        item.setPreco(dto.getPreco());

        return repository.save(item);
    }

    public void deletar(Integer id){

        ItemPedido item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        repository.delete(item);
    }
}

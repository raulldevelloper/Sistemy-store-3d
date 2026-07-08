package com.projectstore.rtdias3d.service;

import com.projectstore.rtdias3d.dtoS.PedidoDTO;
import com.projectstore.rtdias3d.entity.Cliente;
import com.projectstore.rtdias3d.entity.Pedido;
import com.projectstore.rtdias3d.repository.ClienteRepository;
import com.projectstore.rtdias3d.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvar(PedidoDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado " +
                        "/ Customer not found"));

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setPrazoEntrega(dto.getPrazoEntrega());
        pedido.setStatus(dto.getStatus());
        pedido.setValorTotal(dto.getValorTotal());

        return pedidoRepository.save(pedido);
    }
    //////////////////////////////////////////////////////////////////////////////////////

    public Pedido atualizar(Integer id, PedidoDTO dto){

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado / Order not found"));

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado / Customer not found"));

        pedido.setCliente(cliente);
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setPrazoEntrega(dto.getPrazoEntrega());
        pedido.setStatus(dto.getStatus());
        pedido.setValorTotal(dto.getValorTotal());

        return pedidoRepository.save(pedido);
    }

    public void deletar(Integer id){

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado / Order not found"));

        pedidoRepository.delete(pedido);
    }
}

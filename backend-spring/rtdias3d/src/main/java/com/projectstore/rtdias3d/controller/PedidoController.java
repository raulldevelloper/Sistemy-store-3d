package com.projectstore.rtdias3d.controller;

import com.projectstore.rtdias3d.dtoS.PedidoDTO;
import com.projectstore.rtdias3d.entity.Pedido;
import com.projectstore.rtdias3d.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @GetMapping
    public List<Pedido> listar(){
        return service.listarTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Pedido salvar(@RequestBody @Valid PedidoDTO dto){
        return service.salvar(dto);
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Integer id,
                            @RequestBody @Valid PedidoDTO dto){

        return service.atualizar(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }
}

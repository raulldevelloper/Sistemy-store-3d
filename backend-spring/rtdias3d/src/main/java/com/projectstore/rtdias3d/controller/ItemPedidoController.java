package com.projectstore.rtdias3d.controller;

import com.projectstore.rtdias3d.dtoS.ItemPedidoDTO;
import com.projectstore.rtdias3d.entity.ItemPedido;
import com.projectstore.rtdias3d.service.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService service;

    @GetMapping
    public List<ItemPedido> listar(){
        return service.listarTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ItemPedido salvar(@RequestBody @Valid ItemPedidoDTO dto){
        return service.salvar(dto);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ItemPedido atualizar(@PathVariable Integer id,
                                @RequestBody @Valid ItemPedidoDTO dto){

        return service.atualizar(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }
}

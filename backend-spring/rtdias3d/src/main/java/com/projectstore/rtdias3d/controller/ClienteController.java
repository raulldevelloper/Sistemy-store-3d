package com.projectstore.rtdias3d.controller;

import com.projectstore.rtdias3d.dtoS.ClienteDTO;
import com.projectstore.rtdias3d.entity.Cliente;
import com.projectstore.rtdias3d.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public List<Cliente> listar(){
        return service.listarTodos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Cliente salvar(@RequestBody @Valid ClienteDTO dto){
        return service.salvar(dto);
    }
    /////////////////////////////////////////////////////////////////////////////////////////

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Integer id,
                             @RequestBody @Valid ClienteDTO dto){

        return service.atualizar(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }
}

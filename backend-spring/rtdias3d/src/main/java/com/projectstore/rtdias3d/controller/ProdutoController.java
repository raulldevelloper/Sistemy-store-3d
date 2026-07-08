package com.projectstore.rtdias3d.controller;

import com.projectstore.rtdias3d.dtoS.ProdutoDTO;
import com.projectstore.rtdias3d.entity.Produto;
import com.projectstore.rtdias3d.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public List<Produto> listar(){
        return service.listarTodos();
    }

    @PostMapping
    public Produto salvar(@RequestBody @Valid ProdutoDTO dto){
        return service.salvar(dto);
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Integer id,
                             @RequestBody @Valid ProdutoDTO dto){

        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        service.deletar(id);
    }
}

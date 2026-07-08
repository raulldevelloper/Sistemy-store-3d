package com.projectstore.rtdias3d.service;

import com.projectstore.rtdias3d.dtoS.ProdutoDTO;
import com.projectstore.rtdias3d.entity.Produto;
import com.projectstore.rtdias3d.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto salvar(ProdutoDTO dto) {

        Produto produto = new Produto();

        produto.setNome(dto.getNome());
        produto.setCategoria(dto.getCategoria());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setMaterial(dto.getMaterial());
        produto.setTempoPreparo(dto.getTempoPreparo());

        return repository.save(produto);
    }
    /////////////////////////////////////////////////////////
    public Produto atualizar(Integer id, ProdutoDTO dto){

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado / Product not found"));

        produto.setNome(dto.getNome());
        produto.setCategoria(dto.getCategoria());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setMaterial(dto.getMaterial());
        produto.setTempoPreparo(dto.getTempoPreparo());

        return repository.save(produto);
    }

    public void deletar(Integer id){

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado / Product not found"));

        repository.delete(produto);
    }
}

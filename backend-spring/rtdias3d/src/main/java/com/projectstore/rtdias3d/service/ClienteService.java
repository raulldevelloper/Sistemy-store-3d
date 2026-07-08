package com.projectstore.rtdias3d.service;

import com.projectstore.rtdias3d.dtoS.ClienteDTO;
import com.projectstore.rtdias3d.entity.Cliente;
import com.projectstore.rtdias3d.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(ClienteDTO dto){

        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());

        return repository.save(cliente);
    }
    ///////////////////////////////////////////////////////////////////

    public Cliente atualizar(Integer id, ClienteDTO dto){

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado / Customer not found"));

        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());

        return repository.save(cliente);
    }

    public void deletar(Integer id){

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado / Customer not found"));

        repository.delete(cliente);
    }
}

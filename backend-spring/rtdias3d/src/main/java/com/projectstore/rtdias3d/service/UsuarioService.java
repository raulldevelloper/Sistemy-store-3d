package com.projectstore.rtdias3d.service;

import com.projectstore.rtdias3d.dtoS.RegisterDTO;
import com.projectstore.rtdias3d.entity.UsuarioEntity;
import com.projectstore.rtdias3d.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.projectstore.rtdias3d.dtoS.LoginDTO;
import com.projectstore.rtdias3d.dtoS.LoginResponseDTO;
import com.projectstore.rtdias3d.security.JwtService;

@Service
public class UsuarioService implements UserDetailsService {


    private final UsuarioRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public UsuarioService(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder, JwtService jwtService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }



    public UsuarioEntity cadastrar(RegisterDTO dto){


        UsuarioEntity usuario = new UsuarioEntity();


        usuario.setNome(dto.getNome());

        usuario.setEmail(dto.getEmail());


        // criptografando senha
        usuario.setSenha(
                passwordEncoder.encode(dto.getSenha())
        );


        // primeiro usuário será admin
        usuario.setRole("ADMIN");


        return repository.save(usuario);

    }


    public LoginResponseDTO login(LoginDTO dto) {

        UsuarioEntity usuario = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.gerarToken(usuario.getEmail());

        return new LoginResponseDTO(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        UsuarioEntity usuario = repository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(usuario.getRole())
                .build();
    }

}

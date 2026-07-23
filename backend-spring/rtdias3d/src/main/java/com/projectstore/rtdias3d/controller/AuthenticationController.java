package com.projectstore.rtdias3d.controller;

import com.projectstore.rtdias3d.dtoS.LoginDTO;
import com.projectstore.rtdias3d.dtoS.LoginResponseDTO;
import com.projectstore.rtdias3d.dtoS.RegisterDTO;
import com.projectstore.rtdias3d.entity.UsuarioEntity;
import com.projectstore.rtdias3d.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UsuarioService service;

    public AuthenticationController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioEntity> cadastrar(@RequestBody RegisterDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO dto) {

        return ResponseEntity.ok(service.login(dto));
    }

}

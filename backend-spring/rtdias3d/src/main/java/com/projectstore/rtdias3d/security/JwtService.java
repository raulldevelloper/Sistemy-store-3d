package com.projectstore.rtdias3d.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    private final String SECRET = "RTDias3D-Token-Secreto-2026";

    public String gerarToken(String email) {

        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create()
                .withSubject(email)
                .withIssuedAt(Instant.now())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);
    }

    public String validarToken(String token) {

        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant dataExpiracao() {

        return LocalDateTime.now()
                .plusHours(24)
                .toInstant(ZoneOffset.of("-03:00"));
    }

}

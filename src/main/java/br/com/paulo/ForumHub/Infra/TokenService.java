package br.com.paulo.ForumHub.Infra;

import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret ;

    public String gerarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return  JWT.create()
                    .withIssuer("API Forum.Hub")//que esta gerando a api(geralmente a dona da aplicacao)
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt",exception);
            // Invalid Signing configuration / Couldn't convert Claims.
        }
    }
    public String getSubject(String tokenJWT){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return  JWT.require(algoritmo)
                    .withIssuer("API Forum.Hub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirdo!"+tokenJWT);
        }

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

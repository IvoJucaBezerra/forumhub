package br.com.alura.forumhub.infra.security;

import br.com.alura.forumhub.domain.user.UsuarioRepository;
import br.com.alura.forumhub.infra.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component(value = "mySecurityFilter")
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    public final TokenService tokenService;
    public final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);

            var usuario = usuarioRepository.findByEmail(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            if (!authorizationHeader.startsWith("Bearer ")) {
                throw new RuntimeException("O prefixo do Token JWT não é válido!");
            }

            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }
}

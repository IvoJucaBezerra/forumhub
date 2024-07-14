package br.com.alura.forumhub.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Forum Hub Alura API",
        description = "Challenge Forum Hub da turma 6 do programa Next ONE-Alura",
        version = "2.0",
        contact = @Contact(name = "IvoJucaBezerra", email = "ivojucabezerra@gmail.com", url = "https://github.com/IvoJucaBezerra"))
)
@SecurityScheme(
        name = "TokenJWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {
}

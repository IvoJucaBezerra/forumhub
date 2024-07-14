package br.com.alura.forumhub.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosLogin(@NotBlank @Email String email, @NotBlank String senha) {
}

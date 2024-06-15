package com.InnGen.models;

public record RegisterDTO(Long id, String nome, String cpf_cnpj, String login, String senha, String status, UserRole role) {
}

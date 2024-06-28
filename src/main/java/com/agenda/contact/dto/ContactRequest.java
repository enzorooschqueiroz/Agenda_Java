package com.agenda.contact.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactRequest(  
        @NotBlank(message = "Nome não pode ser vazio")
        String nome,

        @NotBlank(message = "Email não pode ser vazio")
        @Email(message = "Email deve ser válido")
        String email,

        @NotBlank(message = "Telefone não pode ser vazio")
        String telefone,

        @NotBlank(message = "Endereço não pode ser vazio")
        String endereco,

        @NotBlank(message = "Aniversário não pode ser vazio")
        String aniversario,

        String genero,
        String categoria,

        @NotNull(message = "Favorito não pode ser nulo")
        boolean favorito
        
        ) {

    
}

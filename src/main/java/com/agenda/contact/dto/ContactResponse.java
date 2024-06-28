package com.agenda.contact.dto;

public record ContactResponse(int id,
                                String nome,
                                String email,
                                String telefone,
                                String endereco,
                                String aniversario,
                                String genero,
                                String categoria,
                                boolean favorito) {
    
}

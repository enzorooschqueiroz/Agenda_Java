package com.agenda.contact.mapping;

import com.agenda.contact.dto.ContactRequest;
import com.agenda.contact.dto.ContactResponse;
import com.agenda.contact.entities.Contact;

public class ContactMapper {
    
    public static Contact toEntity(ContactRequest request){
        Contact contact = new Contact();
        contact.setNome(request.nome());
        contact.setEmail(request.email());
        contact.setTelefone(request.telefone());
        contact.setEndereco(request.endereco());
        contact.setAniversario(request.aniversario());
        contact.setGenero(request.genero());
        contact.setCategoria(request.categoria());
        contact.setFavorito(request.favorito());
        return contact;
    }
    

    public static ContactResponse toDTO(Contact contact){
        return new ContactResponse(
            contact.getId(),
            contact.getNome(),
            contact.getEmail(),
            contact.getTelefone(),
            contact.getEndereco(),
            contact.getAniversario(),
            contact.getGenero(),
            contact.getCategoria(),
            contact.getFavorito()
        );
    }
}
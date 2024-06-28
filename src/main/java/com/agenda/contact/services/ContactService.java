package com.agenda.contact.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.contact.dto.ContactRequest;
import com.agenda.contact.dto.ContactResponse;
import com.agenda.contact.entities.Contact;
import com.agenda.contact.mapping.ContactMapper;
import com.agenda.contact.repositories.ContactRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;

    public List<ContactResponse> getContacts(){
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                       .map(ContactMapper::toDTO)
                       .collect(Collectors.toList());
    }
    
    public List<ContactResponse> getFavoriteContacts() {
        List<Contact> favoriteContacts = contactRepository.findByFavoritoTrue();
        return favoriteContacts.stream()
                               .map(ContactMapper::toDTO)
                               .collect(Collectors.toList());
    }

    public ContactResponse getContactById(int id){
        Contact contact = contactRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não cadastrado")
        );
        return ContactMapper.toDTO(contact);
    }
    
    public void deleteContactById(int id){
        if(this.contactRepository.existsById(id)){
            this.contactRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }
    
    public ContactResponse save(ContactRequest request){
        Contact contact = ContactMapper.toEntity(request);
        return ContactMapper.toDTO(this.contactRepository.save(contact));
    }

    public void update(int id, ContactRequest request){
        try {
            Contact aux = contactRepository.getReferenceById(id);
            aux.setNome(request.nome());
            aux.setEmail(request.email());
            aux.setTelefone(request.telefone());
            aux.setEndereco(request.endereco());
            aux.setAniversario(request.aniversario());
            aux.setGenero(request.genero());
            aux.setCategoria(request.categoria());
            aux.setFavorito(request.favorito());
            this.contactRepository.save(aux);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Contato não cadastrado");
        }
    }
}

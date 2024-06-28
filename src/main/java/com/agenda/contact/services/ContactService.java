package com.agenda.contact.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.contact.entities.Contact;
import com.agenda.contact.repositories.ContactRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }
    
    public List<Contact> getFavoriteContacts() {
        return contactRepository.findByFavoritoTrue();
    }

    public Contact geContactById(int id){
        return contactRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não cadastrado")
        );
    }
    
    public void deleteContactById(int id){
        if(this.contactRepository.existsById(id)){
            this.contactRepository.deleteById(id);
        }else{}
            throw new EntityNotFoundException("Contato não cadastrado");
    }
    
    public Contact save(Contact contact){
        return this.contactRepository.save(contact);
    }

    public void update(int id, Contact contact){
        try{
            Contact aux = contactRepository.getReferenceById(id);
            aux.setNome(contact.getNome());
            aux.setEmail(contact.getEmail());
            aux.setTelefone(contact.getTelefone());
            aux.setAniversario(contact.getAniversario());
            aux.setGenero(contact.getGenero());
            aux.setCategoria(contact.getCategoria());
            aux.setFavorito(contact.getFavorito());
            this.contactRepository.save(aux);
        }catch (Exception e){
            throw new EntityNotFoundException("Contato não registrado");
        }
    }

}

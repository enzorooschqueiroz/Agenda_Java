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

    public Contact geContactById(int id){
        return contactRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não cadastrado")
        );
    }
    
    
}
